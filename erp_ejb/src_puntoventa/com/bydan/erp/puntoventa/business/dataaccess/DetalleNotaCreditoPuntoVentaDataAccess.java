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
import com.bydan.erp.puntoventa.util.*;//DetalleNotaCreditoPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetalleNotaCreditoPuntoVentaDataAccess extends  DetalleNotaCreditoPuntoVentaDataAccessAdditional{ //DetalleNotaCreditoPuntoVentaDataAccessAdditional,DataAccessHelper<DetalleNotaCreditoPuntoVenta>
	//static Logger logger = Logger.getLogger(DetalleNotaCreditoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_nota_credito_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_factura_punto_venta,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,serie,cantidad,precio,descuento,descuento_valor,iva,iva_valor,ice,ice_valor,sub_total,total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_punto_venta=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,serie=?,cantidad=?,precio=?,descuento=?,descuento_valor=?,iva=?,iva_valor=?,ice=?,ice_valor=?,sub_total=?,total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallenotacreditopuntoventa from "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" detallenotacreditopuntoventa";
	public static String QUERYSELECTNATIVE="select "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".serie,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".cantidad,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".precio,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".iva_valor,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".ice_valor,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descripcion from "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleNotaCreditoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_punto_venta=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,serie=?,cantidad=?,precio=?,descuento=?,descuento_valor=?,iva=?,iva_valor=?,ice=?,ice_valor=?,sub_total=?,total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLENOTACREDITOPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLENOTACREDITOPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLENOTACREDITOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLENOTACREDITOPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected DetalleNotaCreditoPuntoVentaDataAccessAdditional detallenotacreditopuntoventaDataAccessAdditional=null;
	
	public DetalleNotaCreditoPuntoVentaDataAccessAdditional getDetalleNotaCreditoPuntoVentaDataAccessAdditional() {
		return this.detallenotacreditopuntoventaDataAccessAdditional;
	}
	
	public void setDetalleNotaCreditoPuntoVentaDataAccessAdditional(DetalleNotaCreditoPuntoVentaDataAccessAdditional detallenotacreditopuntoventaDataAccessAdditional) {
		try {
			this.detallenotacreditopuntoventaDataAccessAdditional=detallenotacreditopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleNotaCreditoPuntoVentaDataAccess() {
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
		DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleNotaCreditoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleNotaCreditoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleNotaCreditoPuntoVentaOriginal(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa)throws Exception  {
		detallenotacreditopuntoventa.setDetalleNotaCreditoPuntoVentaOriginal((DetalleNotaCreditoPuntoVenta)detallenotacreditopuntoventa.clone());		
	}
	
	public void setDetalleNotaCreditoPuntoVentasOriginal(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas)throws Exception  {
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas){
			detallenotacreditopuntoventa.setDetalleNotaCreditoPuntoVentaOriginal((DetalleNotaCreditoPuntoVenta)detallenotacreditopuntoventa.clone());
		}
	}
	
	public static void setDetalleNotaCreditoPuntoVentaOriginalStatic(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa)throws Exception  {
		detallenotacreditopuntoventa.setDetalleNotaCreditoPuntoVentaOriginal((DetalleNotaCreditoPuntoVenta)detallenotacreditopuntoventa.clone());		
	}
	
	public static void setDetalleNotaCreditoPuntoVentasOriginalStatic(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas)throws Exception  {
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas){
			detallenotacreditopuntoventa.setDetalleNotaCreditoPuntoVentaOriginal((DetalleNotaCreditoPuntoVenta)detallenotacreditopuntoventa.clone());
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
	
	public  DetalleNotaCreditoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		
		
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
	
	public  DetalleNotaCreditoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.DetalleNotaCreditoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleNotaCreditoPuntoVentaOriginal(new DetalleNotaCreditoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet); 
				
				//entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleNotaCreditoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();
				
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
	
	public  DetalleNotaCreditoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.DetalleNotaCreditoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleNotaCreditoPuntoVentaOriginal(new DetalleNotaCreditoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet);    
				
				//entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleNotaCreditoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.DetalleNotaCreditoPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		
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
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleNotaCreditoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetalleNotaCreditoPuntoVentaOriginal( new DetalleNotaCreditoPuntoVenta());
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
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
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleNotaCreditoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleNotaCreditoPuntoVenta();
					//entity.setMapDetalleNotaCreditoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleNotaCreditoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleNotaCreditoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleNotaCreditoPuntoVentaDataAccess.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleNotaCreditoPuntoVentaOriginal( new DetalleNotaCreditoPuntoVenta());
					////entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleNotaCreditoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
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
	
	public  DetalleNotaCreditoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleNotaCreditoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleNotaCreditoPuntoVenta();
					//entity.setMapDetalleNotaCreditoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleNotaCreditoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleNotaCreditoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleNotaCreditoPuntoVentaDataAccess.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleNotaCreditoPuntoVentaOriginal( new DetalleNotaCreditoPuntoVenta());
					////entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleNotaCreditoPuntoVenta getEntityDetalleNotaCreditoPuntoVenta(String strPrefijo,DetalleNotaCreditoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleNotaCreditoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleNotaCreditoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleNotaCreditoPuntoVentaDataAccess.setFieldReflectionDetalleNotaCreditoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleNotaCreditoPuntoVenta=DetalleNotaCreditoPuntoVentaConstantesFunciones.getTodosTiposColumnasDetalleNotaCreditoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleNotaCreditoPuntoVenta) {
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
							field = DetalleNotaCreditoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleNotaCreditoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleNotaCreditoPuntoVentaDataAccess.setFieldReflectionDetalleNotaCreditoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleNotaCreditoPuntoVenta(Field field,String strPrefijo,String sColumn,DetalleNotaCreditoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleNotaCreditoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleNotaCreditoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet);
					
					//entity.setDetalleNotaCreditoPuntoVentaOriginal( new DetalleNotaCreditoPuntoVenta());
					//entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleNotaCreditoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleNotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
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
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleNotaCreditoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetalleNotaCreditoPuntoVentaOriginal( new DetalleNotaCreditoPuntoVenta());
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
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
	
	public  List<DetalleNotaCreditoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleNotaCreditoPuntoVenta> entities = new  ArrayList<DetalleNotaCreditoPuntoVenta>();
		DetalleNotaCreditoPuntoVenta entity = new DetalleNotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleNotaCreditoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleNotaCreditoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetalleNotaCreditoPuntoVentaOriginal( new DetalleNotaCreditoPuntoVenta());
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleNotaCreditoPuntoVentaOriginal(this.getEntityDetalleNotaCreditoPuntoVenta("",entity.getDetalleNotaCreditoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleNotaCreditoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleNotaCreditoPuntoVenta getEntityDetalleNotaCreditoPuntoVenta(String strPrefijo,DetalleNotaCreditoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_factura_punto_venta(resultSet.getLong(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IDNOTACREDITOPUNTOVENTA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IDUNIDAD));
				entity.setserie(resultSet.getString(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.SERIE));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.PRECIO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTO));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCUENTOVALOR));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.IVAVALOR));
				entity.setice(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.ICEVALOR));
				entity.setsub_total(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.TOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleNotaCreditoPuntoVentaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleNotaCreditoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleNotaCreditoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleNotaCreditoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleNotaCreditoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleNotaCreditoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleNotaCreditoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleNotaCreditoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleNotaCreditoPuntoVentaDataAccess.TABLENAME,DetalleNotaCreditoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleNotaCreditoPuntoVentaDataAccess.setDetalleNotaCreditoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public NotaCreditoPuntoVenta getNotaCreditoPuntoVenta(Connexion connexion,DetalleNotaCreditoPuntoVenta reldetallenotacreditopuntoventa)throws SQLException,Exception {

		NotaCreditoPuntoVenta notacreditopuntoventa= new NotaCreditoPuntoVenta();

		try {
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			notacreditopuntoventa=notacreditopuntoventaDataAccess.getEntity(connexion,reldetallenotacreditopuntoventa.getid_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventa;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleNotaCreditoPuntoVenta reldetallenotacreditopuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallenotacreditopuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleNotaCreditoPuntoVenta reldetallenotacreditopuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallenotacreditopuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,DetalleNotaCreditoPuntoVenta reldetallenotacreditopuntoventa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallenotacreditopuntoventa.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleNotaCreditoPuntoVenta reldetallenotacreditopuntoventa)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallenotacreditopuntoventa.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleNotaCreditoPuntoVenta reldetallenotacreditopuntoventa)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallenotacreditopuntoventa.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallenotacreditopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura_punto_venta.setValue(detallenotacreditopuntoventa.getid_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallenotacreditopuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallenotacreditopuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallenotacreditopuntoventa.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallenotacreditopuntoventa.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallenotacreditopuntoventa.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detallenotacreditopuntoventa.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallenotacreditopuntoventa.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detallenotacreditopuntoventa.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detallenotacreditopuntoventa.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(detallenotacreditopuntoventa.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallenotacreditopuntoventa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(detallenotacreditopuntoventa.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallenotacreditopuntoventa.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(detallenotacreditopuntoventa.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(detallenotacreditopuntoventa.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detallenotacreditopuntoventa.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallenotacreditopuntoventa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallenotacreditopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallenotacreditopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallenotacreditopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallenotacreditopuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa)throws Exception  {		
		detallenotacreditopuntoventa.setIsNew(false);
		detallenotacreditopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas)throws Exception  {				
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa:detallenotacreditopuntoventas) {
			detallenotacreditopuntoventa.setIsNew(false);
			detallenotacreditopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleNotaCreditoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
