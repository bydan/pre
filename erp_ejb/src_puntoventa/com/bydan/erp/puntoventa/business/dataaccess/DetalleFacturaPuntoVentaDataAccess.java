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
import com.bydan.erp.puntoventa.util.*;//DetalleFacturaPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetalleFacturaPuntoVentaDataAccess extends  DetalleFacturaPuntoVentaDataAccessAdditional{ //DetalleFacturaPuntoVentaDataAccessAdditional,DataAccessHelper<DetalleFacturaPuntoVenta>
	//static Logger logger = Logger.getLogger(DetalleFacturaPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_factura_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_factura_punto_venta,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,serie,cantidad,precio,descuento,descuento_valor,iva,iva_valor,ice,ice_valor,sub_total,total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_punto_venta=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,serie=?,cantidad=?,precio=?,descuento=?,descuento_valor=?,iva=?,iva_valor=?,ice=?,ice_valor=?,sub_total=?,total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallefacturapuntoventa from "+DetalleFacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" detallefacturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_bodega,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id_unidad,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".serie,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".cantidad,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".precio,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".descuento_valor,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".iva,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".iva_valor,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".ice,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".ice_valor,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".total,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".descripcion from "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+DetalleFacturaPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_factura_punto_venta=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,serie=?,cantidad=?,precio=?,descuento=?,descuento_valor=?,iva=?,iva_valor=?,ice=?,ice_valor=?,sub_total=?,total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEFACTURAPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEFACTURAPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEFACTURAPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEFACTURAPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected DetalleFacturaPuntoVentaDataAccessAdditional detallefacturapuntoventaDataAccessAdditional=null;
	
	public DetalleFacturaPuntoVentaDataAccessAdditional getDetalleFacturaPuntoVentaDataAccessAdditional() {
		return this.detallefacturapuntoventaDataAccessAdditional;
	}
	
	public void setDetalleFacturaPuntoVentaDataAccessAdditional(DetalleFacturaPuntoVentaDataAccessAdditional detallefacturapuntoventaDataAccessAdditional) {
		try {
			this.detallefacturapuntoventaDataAccessAdditional=detallefacturapuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleFacturaPuntoVentaDataAccess() {
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
		DetalleFacturaPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleFacturaPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleFacturaPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleFacturaPuntoVentaOriginal(DetalleFacturaPuntoVenta detallefacturapuntoventa)throws Exception  {
		detallefacturapuntoventa.setDetalleFacturaPuntoVentaOriginal((DetalleFacturaPuntoVenta)detallefacturapuntoventa.clone());		
	}
	
	public void setDetalleFacturaPuntoVentasOriginal(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas)throws Exception  {
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas){
			detallefacturapuntoventa.setDetalleFacturaPuntoVentaOriginal((DetalleFacturaPuntoVenta)detallefacturapuntoventa.clone());
		}
	}
	
	public static void setDetalleFacturaPuntoVentaOriginalStatic(DetalleFacturaPuntoVenta detallefacturapuntoventa)throws Exception  {
		detallefacturapuntoventa.setDetalleFacturaPuntoVentaOriginal((DetalleFacturaPuntoVenta)detallefacturapuntoventa.clone());		
	}
	
	public static void setDetalleFacturaPuntoVentasOriginalStatic(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas)throws Exception  {
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas){
			detallefacturapuntoventa.setDetalleFacturaPuntoVentaOriginal((DetalleFacturaPuntoVenta)detallefacturapuntoventa.clone());
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
	
	public  DetalleFacturaPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		
		
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
	
	public  DetalleFacturaPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.DetalleFacturaPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleFacturaPuntoVentaOriginal(new DetalleFacturaPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleFacturaPuntoVenta("",entity,resultSet); 
				
				//entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleFacturaPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleFacturaPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();
				
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
	
	public  DetalleFacturaPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.DetalleFacturaPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleFacturaPuntoVentaOriginal(new DetalleFacturaPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleFacturaPuntoVenta("",entity,resultSet);    
				
				//entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleFacturaPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleFacturaPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.DetalleFacturaPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleFacturaPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleFacturaPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		
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
	
	public  List<DetalleFacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetalleFacturaPuntoVentaOriginal( new DetalleFacturaPuntoVenta());
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleFacturaPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
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
	
	public  List<DetalleFacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleFacturaPuntoVenta();
					//entity.setMapDetalleFacturaPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleFacturaPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleFacturaPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleFacturaPuntoVentaDataAccess.getEntityDetalleFacturaPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleFacturaPuntoVentaOriginal( new DetalleFacturaPuntoVenta());
					////entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleFacturaPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
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
	
	public  DetalleFacturaPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleFacturaPuntoVenta();
					//entity.setMapDetalleFacturaPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleFacturaPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleFacturaPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleFacturaPuntoVentaDataAccess.getEntityDetalleFacturaPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleFacturaPuntoVentaOriginal( new DetalleFacturaPuntoVenta());
					////entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleFacturaPuntoVenta getEntityDetalleFacturaPuntoVenta(String strPrefijo,DetalleFacturaPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleFacturaPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleFacturaPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleFacturaPuntoVentaDataAccess.setFieldReflectionDetalleFacturaPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleFacturaPuntoVenta=DetalleFacturaPuntoVentaConstantesFunciones.getTodosTiposColumnasDetalleFacturaPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleFacturaPuntoVenta) {
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
							field = DetalleFacturaPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleFacturaPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleFacturaPuntoVentaDataAccess.setFieldReflectionDetalleFacturaPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleFacturaPuntoVenta(Field field,String strPrefijo,String sColumn,DetalleFacturaPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleFacturaPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleFacturaPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleFacturaPuntoVenta();
					entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleFacturaPuntoVenta("",entity,resultSet);
					
					//entity.setDetalleFacturaPuntoVentaOriginal( new DetalleFacturaPuntoVenta());
					//entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleFacturaPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleFacturaPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleFacturaPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
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
	
	public  List<DetalleFacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetalleFacturaPuntoVentaOriginal( new DetalleFacturaPuntoVenta());
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleFacturaPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleFacturaPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
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
	
	public  List<DetalleFacturaPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFacturaPuntoVenta> entities = new  ArrayList<DetalleFacturaPuntoVenta>();
		DetalleFacturaPuntoVenta entity = new DetalleFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setDetalleFacturaPuntoVentaOriginal( new DetalleFacturaPuntoVenta());
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(super.getEntity("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet,DetalleFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFacturaPuntoVentaOriginal(this.getEntityDetalleFacturaPuntoVenta("",entity.getDetalleFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFacturaPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleFacturaPuntoVenta getEntityDetalleFacturaPuntoVenta(String strPrefijo,DetalleFacturaPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_factura_punto_venta(resultSet.getLong(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IDUNIDAD));
				entity.setserie(resultSet.getString(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.SERIE));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.PRECIO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTOVALOR));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.IVAVALOR));
				entity.setice(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.ICEVALOR));
				entity.setsub_total(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.TOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleFacturaPuntoVentaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleFacturaPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleFacturaPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleFacturaPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleFacturaPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleFacturaPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleFacturaPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleFacturaPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleFacturaPuntoVentaDataAccess.TABLENAME,DetalleFacturaPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleFacturaPuntoVentaDataAccess.setDetalleFacturaPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public FacturaPuntoVenta getFacturaPuntoVenta(Connexion connexion,DetalleFacturaPuntoVenta reldetallefacturapuntoventa)throws SQLException,Exception {

		FacturaPuntoVenta facturapuntoventa= new FacturaPuntoVenta();

		try {
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion,reldetallefacturapuntoventa.getid_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventa;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleFacturaPuntoVenta reldetallefacturapuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallefacturapuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleFacturaPuntoVenta reldetallefacturapuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallefacturapuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,DetalleFacturaPuntoVenta reldetallefacturapuntoventa)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallefacturapuntoventa.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleFacturaPuntoVenta reldetallefacturapuntoventa)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallefacturapuntoventa.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleFacturaPuntoVenta reldetallefacturapuntoventa)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallefacturapuntoventa.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallefacturapuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura_punto_venta.setValue(detallefacturapuntoventa.getid_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallefacturapuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallefacturapuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallefacturapuntoventa.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallefacturapuntoventa.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallefacturapuntoventa.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detallefacturapuntoventa.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallefacturapuntoventa.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detallefacturapuntoventa.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detallefacturapuntoventa.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(detallefacturapuntoventa.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallefacturapuntoventa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(detallefacturapuntoventa.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallefacturapuntoventa.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(detallefacturapuntoventa.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(detallefacturapuntoventa.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detallefacturapuntoventa.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallefacturapuntoventa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallefacturapuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallefacturapuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallefacturapuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallefacturapuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa)throws Exception  {		
		detallefacturapuntoventa.setIsNew(false);
		detallefacturapuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleFacturaPuntoVentas(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas)throws Exception  {				
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:detallefacturapuntoventas) {
			detallefacturapuntoventa.setIsNew(false);
			detallefacturapuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleFacturaPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
