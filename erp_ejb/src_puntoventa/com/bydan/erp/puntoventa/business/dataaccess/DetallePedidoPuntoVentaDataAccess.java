/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.puntoventa.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//DetallePedidoPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetallePedidoPuntoVentaDataAccess extends  DetallePedidoPuntoVentaDataAccessAdditional{ //DetallePedidoPuntoVentaDataAccessAdditional,DataAccessHelper<DetallePedidoPuntoVenta>
	//static Logger logger = Logger.getLogger(DetallePedidoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_pedido_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_pedido_punto_venta,id_bodega,id_producto,id_unidad,serie,cantidad,precio,descuento,descuento_valor,iva,iva_valor,ice,ice_valor,sub_total,total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pedido_punto_venta=?,id_bodega=?,id_producto=?,id_unidad=?,serie=?,cantidad=?,precio=?,descuento=?,descuento_valor=?,iva=?,iva_valor=?,ice=?,ice_valor=?,sub_total=?,total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallepedidopuntoventa from "+DetallePedidoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" detallepedidopuntoventa";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_pedido_punto_venta,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".serie,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".cantidad,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".precio,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".descuento_valor,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".iva_valor,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".ice_valor,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".total from "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+"."+DetallePedidoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pedido_punto_venta=?,id_bodega=?,id_producto=?,id_unidad=?,serie=?,cantidad=?,precio=?,descuento=?,descuento_valor=?,iva=?,iva_valor=?,ice=?,ice_valor=?,sub_total=?,total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEPEDIDOPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEPEDIDOPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEPEDIDOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEPEDIDOPUNTOVENTA_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected DetallePedidoPuntoVentaDataAccessAdditional detallepedidopuntoventaDataAccessAdditional=null;
	
	public DetallePedidoPuntoVentaDataAccessAdditional getDetallePedidoPuntoVentaDataAccessAdditional() {
		return this.detallepedidopuntoventaDataAccessAdditional;
	}
	
	public void setDetallePedidoPuntoVentaDataAccessAdditional(DetallePedidoPuntoVentaDataAccessAdditional detallepedidopuntoventaDataAccessAdditional) {
		try {
			this.detallepedidopuntoventaDataAccessAdditional=detallepedidopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetallePedidoPuntoVentaDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		DetallePedidoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetallePedidoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetallePedidoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setDetallePedidoPuntoVentaOriginal(DetallePedidoPuntoVenta detallepedidopuntoventa)throws Exception  {
		detallepedidopuntoventa.setDetallePedidoPuntoVentaOriginal((DetallePedidoPuntoVenta)detallepedidopuntoventa.clone());		
	}
	
	public void setDetallePedidoPuntoVentasOriginal(List<DetallePedidoPuntoVenta> detallepedidopuntoventas)throws Exception  {
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas){
			detallepedidopuntoventa.setDetallePedidoPuntoVentaOriginal((DetallePedidoPuntoVenta)detallepedidopuntoventa.clone());
		}
	}
	
	public static void setDetallePedidoPuntoVentaOriginalStatic(DetallePedidoPuntoVenta detallepedidopuntoventa)throws Exception  {
		detallepedidopuntoventa.setDetallePedidoPuntoVentaOriginal((DetallePedidoPuntoVenta)detallepedidopuntoventa.clone());		
	}
	
	public static void setDetallePedidoPuntoVentasOriginalStatic(List<DetallePedidoPuntoVenta> detallepedidopuntoventas)throws Exception  {
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas){
			detallepedidopuntoventa.setDetallePedidoPuntoVentaOriginal((DetallePedidoPuntoVenta)detallepedidopuntoventa.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  DetallePedidoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  DetallePedidoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.DetallePedidoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetallePedidoPuntoVentaOriginal(new DetallePedidoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoPuntoVenta("",entity,resultSet); 
				
				//entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetallePedidoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  DetallePedidoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.DetallePedidoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetallePedidoPuntoVentaOriginal(new DetallePedidoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoPuntoVenta("",entity,resultSet);    
				
				//entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetallePedidoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.DetallePedidoPuntoVenta.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseDetallePedidoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetallePedidoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DetallePedidoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetallePedidoPuntoVentaOriginal( new DetallePedidoPuntoVenta());
      	    	//entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DetallePedidoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoPuntoVenta();
					//entity.setMapDetallePedidoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetallePedidoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoPuntoVentaDataAccess.getEntityDetallePedidoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoPuntoVentaOriginal( new DetallePedidoPuntoVenta());
					////entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetallePedidoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  DetallePedidoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoPuntoVenta();
					//entity.setMapDetallePedidoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetallePedidoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoPuntoVentaDataAccess.getEntityDetallePedidoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoPuntoVentaOriginal( new DetallePedidoPuntoVenta());
					////entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetallePedidoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetallePedidoPuntoVenta getEntityDetallePedidoPuntoVenta(String strPrefijo,DetallePedidoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetallePedidoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetallePedidoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetallePedidoPuntoVentaDataAccess.setFieldReflectionDetallePedidoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetallePedidoPuntoVenta=DetallePedidoPuntoVentaConstantesFunciones.getTodosTiposColumnasDetallePedidoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetallePedidoPuntoVenta) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = DetallePedidoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetallePedidoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetallePedidoPuntoVentaDataAccess.setFieldReflectionDetallePedidoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetallePedidoPuntoVenta(Field field,String strPrefijo,String sColumn,DetallePedidoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetallePedidoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoPuntoVentaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new DetallePedidoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetallePedidoPuntoVenta("",entity,resultSet);
					
					//entity.setDetallePedidoPuntoVentaOriginal( new DetallePedidoPuntoVenta());
					//entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetallePedidoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<DetallePedidoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DetallePedidoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetallePedidoPuntoVentaOriginal( new DetallePedidoPuntoVenta());
      	    	//entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetallePedidoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DetallePedidoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoPuntoVenta> entities = new  ArrayList<DetallePedidoPuntoVenta>();
		DetallePedidoPuntoVenta entity = new DetallePedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetallePedidoPuntoVentaOriginal( new DetallePedidoPuntoVenta());
      	    	//entity.setDetallePedidoPuntoVentaOriginal(super.getEntity("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet,DetallePedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoPuntoVentaOriginal(this.getEntityDetallePedidoPuntoVenta("",entity.getDetallePedidoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetallePedidoPuntoVenta getEntityDetallePedidoPuntoVenta(String strPrefijo,DetallePedidoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_pedido_punto_venta(resultSet.getLong(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IDPEDIDOPUNTOVENTA));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IDUNIDAD));
				entity.setserie(resultSet.getString(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.SERIE));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.PRECIO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.DESCUENTOVALOR));
				entity.setiva(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.IVAVALOR));
				entity.setice(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.ICEVALOR));
				entity.setsub_total(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+DetallePedidoPuntoVentaConstantesFunciones.TOTAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetallePedidoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetallePedidoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetallePedidoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetallePedidoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetallePedidoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetallePedidoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetallePedidoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetallePedidoPuntoVentaDataAccess.TABLENAME,DetallePedidoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetallePedidoPuntoVentaDataAccess.setDetallePedidoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetallePedidoPuntoVenta reldetallepedidopuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallepedidopuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetallePedidoPuntoVenta reldetallepedidopuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallepedidopuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public PedidoPuntoVenta getPedidoPuntoVenta(Connexion connexion,DetallePedidoPuntoVenta reldetallepedidopuntoventa)throws SQLException,Exception {

		PedidoPuntoVenta pedidopuntoventa= new PedidoPuntoVenta();

		try {
			PedidoPuntoVentaDataAccess pedidopuntoventaDataAccess=new PedidoPuntoVentaDataAccess();

			pedidopuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			pedidopuntoventa=pedidopuntoventaDataAccess.getEntity(connexion,reldetallepedidopuntoventa.getid_pedido_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidopuntoventa;

	}

	public Bodega getBodega(Connexion connexion,DetallePedidoPuntoVenta reldetallepedidopuntoventa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallepedidopuntoventa.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetallePedidoPuntoVenta reldetallepedidopuntoventa)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallepedidopuntoventa.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetallePedidoPuntoVenta reldetallepedidopuntoventa)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallepedidopuntoventa.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallepedidopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallepedidopuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallepedidopuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_punto_venta.setValue(detallepedidopuntoventa.getid_pedido_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallepedidopuntoventa.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallepedidopuntoventa.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallepedidopuntoventa.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detallepedidopuntoventa.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallepedidopuntoventa.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detallepedidopuntoventa.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detallepedidopuntoventa.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(detallepedidopuntoventa.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallepedidopuntoventa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(detallepedidopuntoventa.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallepedidopuntoventa.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(detallepedidopuntoventa.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(detallepedidopuntoventa.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detallepedidopuntoventa.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallepedidopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallepedidopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallepedidopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallepedidopuntoventa.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa)throws Exception  {		
		detallepedidopuntoventa.setIsNew(false);
		detallepedidopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> detallepedidopuntoventas)throws Exception  {				
		for(DetallePedidoPuntoVenta detallepedidopuntoventa:detallepedidopuntoventas) {
			detallepedidopuntoventa.setIsNew(false);
			detallepedidopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarDetallePedidoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
