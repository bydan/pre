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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//DetalleDescuenPoliVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class DetalleDescuenPoliVentaDataAccess extends  DetalleDescuenPoliVentaDataAccessAdditional{ //DetalleDescuenPoliVentaDataAccessAdditional,DataAccessHelper<DetalleDescuenPoliVenta>
	//static Logger logger = Logger.getLogger(DetalleDescuenPoliVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_descuen_poli_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_cliente,valor,descripcion)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cliente=?,valor=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalledescuenpoliventa from "+DetalleDescuenPoliVentaConstantesFunciones.SPERSISTENCENAME+" detalledescuenpoliventa";
	public static String QUERYSELECTNATIVE="select "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".version_row,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id_cliente,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".valor,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".descripcion from "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME;//+" as "+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".id,"+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+".version_row from "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME;//+" as "+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+"."+DetalleDescuenPoliVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cliente=?,valor=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEDESCUENPOLIVENTA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEDESCUENPOLIVENTA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEDESCUENPOLIVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEDESCUENPOLIVENTA_SELECT(?,?)";
	
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
	
	
	protected DetalleDescuenPoliVentaDataAccessAdditional detalledescuenpoliventaDataAccessAdditional=null;
	
	public DetalleDescuenPoliVentaDataAccessAdditional getDetalleDescuenPoliVentaDataAccessAdditional() {
		return this.detalledescuenpoliventaDataAccessAdditional;
	}
	
	public void setDetalleDescuenPoliVentaDataAccessAdditional(DetalleDescuenPoliVentaDataAccessAdditional detalledescuenpoliventaDataAccessAdditional) {
		try {
			this.detalledescuenpoliventaDataAccessAdditional=detalledescuenpoliventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleDescuenPoliVentaDataAccess() {
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
		DetalleDescuenPoliVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleDescuenPoliVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleDescuenPoliVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleDescuenPoliVentaOriginal(DetalleDescuenPoliVenta detalledescuenpoliventa)throws Exception  {
		detalledescuenpoliventa.setDetalleDescuenPoliVentaOriginal((DetalleDescuenPoliVenta)detalledescuenpoliventa.clone());		
	}
	
	public void setDetalleDescuenPoliVentasOriginal(List<DetalleDescuenPoliVenta> detalledescuenpoliventas)throws Exception  {
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas){
			detalledescuenpoliventa.setDetalleDescuenPoliVentaOriginal((DetalleDescuenPoliVenta)detalledescuenpoliventa.clone());
		}
	}
	
	public static void setDetalleDescuenPoliVentaOriginalStatic(DetalleDescuenPoliVenta detalledescuenpoliventa)throws Exception  {
		detalledescuenpoliventa.setDetalleDescuenPoliVentaOriginal((DetalleDescuenPoliVenta)detalledescuenpoliventa.clone());		
	}
	
	public static void setDetalleDescuenPoliVentasOriginalStatic(List<DetalleDescuenPoliVenta> detalledescuenpoliventas)throws Exception  {
		
		for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas){
			detalledescuenpoliventa.setDetalleDescuenPoliVentaOriginal((DetalleDescuenPoliVenta)detalledescuenpoliventa.clone());
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
	
	public  DetalleDescuenPoliVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		
		
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
	
	public  DetalleDescuenPoliVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetalleDescuenPoliVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleDescuenPoliVentaOriginal(new DetalleDescuenPoliVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleDescuenPoliVenta("",entity,resultSet); 
				
				//entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleDescuenPoliVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleDescuenPoliVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();
				
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
	
	public  DetalleDescuenPoliVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleDescuenPoliVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleDescuenPoliVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleDescuenPoliVentaOriginal(new DetalleDescuenPoliVenta());
      	    	entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleDescuenPoliVenta("",entity,resultSet);    
				
				//entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleDescuenPoliVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleDescuenPoliVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleDescuenPoliVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleDescuenPoliVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleDescuenPoliVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleDescuenPoliVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		
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
	
	public  List<DetalleDescuenPoliVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleDescuenPoliVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleDescuenPoliVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleDescuenPoliVenta("",entity,resultSet);
      	    	
				//entity.setDetalleDescuenPoliVentaOriginal( new DetalleDescuenPoliVenta());
      	    	//entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleDescuenPoliVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleDescuenPoliVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleDescuenPoliVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
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
	
	public  List<DetalleDescuenPoliVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleDescuenPoliVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleDescuenPoliVenta();
					//entity.setMapDetalleDescuenPoliVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleDescuenPoliVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleDescuenPoliVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleDescuenPoliVentaDataAccess.getEntityDetalleDescuenPoliVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleDescuenPoliVentaOriginal( new DetalleDescuenPoliVenta());
					////entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleDescuenPoliVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleDescuenPoliVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleDescuenPoliVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
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
	
	public  DetalleDescuenPoliVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleDescuenPoliVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleDescuenPoliVenta();
					//entity.setMapDetalleDescuenPoliVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleDescuenPoliVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleDescuenPoliVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleDescuenPoliVentaDataAccess.getEntityDetalleDescuenPoliVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleDescuenPoliVentaOriginal( new DetalleDescuenPoliVenta());
					////entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleDescuenPoliVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleDescuenPoliVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleDescuenPoliVenta getEntityDetalleDescuenPoliVenta(String strPrefijo,DetalleDescuenPoliVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleDescuenPoliVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleDescuenPoliVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleDescuenPoliVentaDataAccess.setFieldReflectionDetalleDescuenPoliVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleDescuenPoliVenta=DetalleDescuenPoliVentaConstantesFunciones.getTodosTiposColumnasDetalleDescuenPoliVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleDescuenPoliVenta) {
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
							field = DetalleDescuenPoliVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleDescuenPoliVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleDescuenPoliVentaDataAccess.setFieldReflectionDetalleDescuenPoliVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleDescuenPoliVenta(Field field,String strPrefijo,String sColumn,DetalleDescuenPoliVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleDescuenPoliVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleDescuenPoliVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleDescuenPoliVentaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleDescuenPoliVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleDescuenPoliVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleDescuenPoliVenta();
					entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleDescuenPoliVenta("",entity,resultSet);
					
					//entity.setDetalleDescuenPoliVentaOriginal( new DetalleDescuenPoliVenta());
					//entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleDescuenPoliVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleDescuenPoliVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleDescuenPoliVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleDescuenPoliVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleDescuenPoliVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleDescuenPoliVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
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
	
	public  List<DetalleDescuenPoliVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleDescuenPoliVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleDescuenPoliVenta("",entity,resultSet);
      	    	
				//entity.setDetalleDescuenPoliVentaOriginal( new DetalleDescuenPoliVenta());
      	    	//entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleDescuenPoliVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleDescuenPoliVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleDescuenPoliVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
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
	
	public  List<DetalleDescuenPoliVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleDescuenPoliVenta> entities = new  ArrayList<DetalleDescuenPoliVenta>();
		DetalleDescuenPoliVenta entity = new DetalleDescuenPoliVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleDescuenPoliVenta();
      	    	entity=super.getEntity("",entity,resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleDescuenPoliVenta("",entity,resultSet);
      	    	
				//entity.setDetalleDescuenPoliVentaOriginal( new DetalleDescuenPoliVenta());
      	    	//entity.setDetalleDescuenPoliVentaOriginal(super.getEntity("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet,DetalleDescuenPoliVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleDescuenPoliVentaOriginal(this.getEntityDetalleDescuenPoliVenta("",entity.getDetalleDescuenPoliVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleDescuenPoliVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleDescuenPoliVenta getEntityDetalleDescuenPoliVenta(String strPrefijo,DetalleDescuenPoliVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleDescuenPoliVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleDescuenPoliVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+DetalleDescuenPoliVentaConstantesFunciones.IDCLIENTE));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetalleDescuenPoliVentaConstantesFunciones.VALOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleDescuenPoliVentaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleDescuenPoliVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleDescuenPoliVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleDescuenPoliVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleDescuenPoliVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleDescuenPoliVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleDescuenPoliVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleDescuenPoliVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleDescuenPoliVentaDataAccess.TABLENAME,DetalleDescuenPoliVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleDescuenPoliVentaDataAccess.setDetalleDescuenPoliVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleDescuenPoliVenta reldetalledescuenpoliventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalledescuenpoliventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleDescuenPoliVenta reldetalledescuenpoliventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalledescuenpoliventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,DetalleDescuenPoliVenta reldetalledescuenpoliventa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldetalledescuenpoliventa.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleDescuenPoliVenta detalledescuenpoliventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalledescuenpoliventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalledescuenpoliventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalledescuenpoliventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(detalledescuenpoliventa.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detalledescuenpoliventa.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalledescuenpoliventa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalledescuenpoliventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalledescuenpoliventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalledescuenpoliventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalledescuenpoliventa.getId());
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
	
	public void setIsNewIsChangedFalseDetalleDescuenPoliVenta(DetalleDescuenPoliVenta detalledescuenpoliventa)throws Exception  {		
		detalledescuenpoliventa.setIsNew(false);
		detalledescuenpoliventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleDescuenPoliVentas(List<DetalleDescuenPoliVenta> detalledescuenpoliventas)throws Exception  {				
		for(DetalleDescuenPoliVenta detalledescuenpoliventa:detalledescuenpoliventas) {
			detalledescuenpoliventa.setIsNew(false);
			detalledescuenpoliventa.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleDescuenPoliVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
