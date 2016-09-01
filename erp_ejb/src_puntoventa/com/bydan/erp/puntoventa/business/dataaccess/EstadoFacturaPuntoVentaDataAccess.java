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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//EstadoFacturaPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class EstadoFacturaPuntoVentaDataAccess extends  DataAccessHelperSinIdGenerated<EstadoFacturaPuntoVenta>{ //EstadoFacturaPuntoVentaDataAccessAdditional,DataAccessHelper<EstadoFacturaPuntoVenta>
	//static Logger logger = Logger.getLogger(EstadoFacturaPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_factura_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadofacturapuntoventa from "+EstadoFacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" estadofacturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".nombre from "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".nombre from "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOFACTURAPUNTOVENTA_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOFACTURAPUNTOVENTA_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOFACTURAPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOFACTURAPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	public EstadoFacturaPuntoVentaDataAccess() {
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
		EstadoFacturaPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoFacturaPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoFacturaPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoFacturaPuntoVentaOriginal(EstadoFacturaPuntoVenta estadofacturapuntoventa)throws Exception  {
		estadofacturapuntoventa.setEstadoFacturaPuntoVentaOriginal((EstadoFacturaPuntoVenta)estadofacturapuntoventa.clone());		
	}
	
	public void setEstadoFacturaPuntoVentasOriginal(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas)throws Exception  {
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa:estadofacturapuntoventas){
			estadofacturapuntoventa.setEstadoFacturaPuntoVentaOriginal((EstadoFacturaPuntoVenta)estadofacturapuntoventa.clone());
		}
	}
	
	public static void setEstadoFacturaPuntoVentaOriginalStatic(EstadoFacturaPuntoVenta estadofacturapuntoventa)throws Exception  {
		estadofacturapuntoventa.setEstadoFacturaPuntoVentaOriginal((EstadoFacturaPuntoVenta)estadofacturapuntoventa.clone());		
	}
	
	public static void setEstadoFacturaPuntoVentasOriginalStatic(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas)throws Exception  {
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa:estadofacturapuntoventas){
			estadofacturapuntoventa.setEstadoFacturaPuntoVentaOriginal((EstadoFacturaPuntoVenta)estadofacturapuntoventa.clone());
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
	
	public  EstadoFacturaPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		
		
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
	
	public  EstadoFacturaPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.EstadoFacturaPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoFacturaPuntoVentaOriginal(new EstadoFacturaPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoFacturaPuntoVenta("",entity,resultSet); 
				
				//entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoFacturaPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoFacturaPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();
				
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
	
	public  EstadoFacturaPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.EstadoFacturaPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoFacturaPuntoVentaOriginal(new EstadoFacturaPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoFacturaPuntoVenta("",entity,resultSet);    
				
				//entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoFacturaPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoFacturaPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.EstadoFacturaPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoFacturaPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoFacturaPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		
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
	
	public  List<EstadoFacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setEstadoFacturaPuntoVentaOriginal( new EstadoFacturaPuntoVenta());
      	    	//entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFacturaPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoFacturaPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
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
	
	public  List<EstadoFacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFacturaPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoFacturaPuntoVenta();
					//entity.setMapEstadoFacturaPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoFacturaPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoFacturaPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoFacturaPuntoVentaDataAccess.getEntityEstadoFacturaPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoFacturaPuntoVentaOriginal( new EstadoFacturaPuntoVenta());
					////entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFacturaPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoFacturaPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
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
	
	public  EstadoFacturaPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFacturaPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoFacturaPuntoVenta();
					//entity.setMapEstadoFacturaPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoFacturaPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoFacturaPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoFacturaPuntoVentaDataAccess.getEntityEstadoFacturaPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoFacturaPuntoVentaOriginal( new EstadoFacturaPuntoVenta());
					////entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoFacturaPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoFacturaPuntoVenta getEntityEstadoFacturaPuntoVenta(String strPrefijo,EstadoFacturaPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoFacturaPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoFacturaPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoFacturaPuntoVentaDataAccess.setFieldReflectionEstadoFacturaPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoFacturaPuntoVenta=EstadoFacturaPuntoVentaConstantesFunciones.getTodosTiposColumnasEstadoFacturaPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoFacturaPuntoVenta) {
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
							field = EstadoFacturaPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoFacturaPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoFacturaPuntoVentaDataAccess.setFieldReflectionEstadoFacturaPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoFacturaPuntoVenta(Field field,String strPrefijo,String sColumn,EstadoFacturaPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoFacturaPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoFacturaPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoFacturaPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoFacturaPuntoVenta();
					entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoFacturaPuntoVenta("",entity,resultSet);
					
					//entity.setEstadoFacturaPuntoVentaOriginal( new EstadoFacturaPuntoVenta());
					//entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoFacturaPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoFacturaPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFacturaPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFacturaPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoFacturaPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
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
	
	public  List<EstadoFacturaPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFacturaPuntoVenta> entities = new  ArrayList<EstadoFacturaPuntoVenta>();
		EstadoFacturaPuntoVenta entity = new EstadoFacturaPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFacturaPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFacturaPuntoVenta("",entity,resultSet);
      	    	
				//entity.setEstadoFacturaPuntoVentaOriginal( new EstadoFacturaPuntoVenta());
      	    	//entity.setEstadoFacturaPuntoVentaOriginal(super.getEntity("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet,EstadoFacturaPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFacturaPuntoVentaOriginal(this.getEntityEstadoFacturaPuntoVenta("",entity.getEstadoFacturaPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoFacturaPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFacturaPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoFacturaPuntoVenta getEntityEstadoFacturaPuntoVenta(String strPrefijo,EstadoFacturaPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoFacturaPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoFacturaPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoFacturaPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoFacturaPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoFacturaPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoFacturaPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoFacturaPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoFacturaPuntoVentaDataAccess.TABLENAME,EstadoFacturaPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoFacturaPuntoVentaDataAccess.setEstadoFacturaPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<FacturaPuntoVenta> getFacturaPuntoVentas(Connexion connexion,EstadoFacturaPuntoVenta estadofacturapuntoventa)throws SQLException,Exception {

		List<FacturaPuntoVenta> facturapuntoventas= new ArrayList<FacturaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+".estado_factura_punto_venta ON "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id_estado_factura_punto_venta="+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+".estado_factura_punto_venta.id WHERE "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+".estado_factura_punto_venta.id="+String.valueOf(estadofacturapuntoventa.getId());
			} else {
				sQuery=" INNER JOIN facturapuntoventa.EstadoFacturaPuntoVenta WHERE facturapuntoventa.EstadoFacturaPuntoVenta.id="+String.valueOf(estadofacturapuntoventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoFacturaPuntoVenta estadofacturapuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadofacturapuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadofacturapuntoventa.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadofacturapuntoventa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadofacturapuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadofacturapuntoventa.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadofacturapuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadofacturapuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventa)throws Exception  {		
		estadofacturapuntoventa.setIsNew(false);
		estadofacturapuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoFacturaPuntoVentas(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas)throws Exception  {				
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa:estadofacturapuntoventas) {
			estadofacturapuntoventa.setIsNew(false);
			estadofacturapuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoFacturaPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
