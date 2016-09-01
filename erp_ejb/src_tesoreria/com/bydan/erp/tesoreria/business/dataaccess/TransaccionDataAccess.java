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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//TransaccionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;




@SuppressWarnings("unused")
final public class TransaccionDataAccess extends  TransaccionDataAccessAdditional{ //TransaccionDataAccessAdditional,DataAccessHelper<Transaccion>
	//static Logger logger = Logger.getLogger(TransaccionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transaccion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,codigo,nombre,id_modulo,id_tipo_transa,id_tipo_comprobante,id_tipo_transaccion_modulo,id_tipo_retencion,id_cuenta_contable,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,nombre=?,id_modulo=?,id_tipo_transa=?,id_tipo_comprobante=?,id_tipo_transaccion_modulo=?,id_tipo_retencion=?,id_cuenta_contable=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transaccion from "+TransaccionConstantesFunciones.SPERSISTENCENAME+" transaccion";
	public static String QUERYSELECTNATIVE="select "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".version_row,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_sucursal,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".codigo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".nombre,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_modulo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_transa,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".descripcion from "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME;//+" as "+TransaccionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".id,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".version_row,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".codigo,"+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+".nombre from "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME;//+" as "+TransaccionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransaccionConstantesFunciones.SCHEMA+"."+TransaccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,nombre=?,id_modulo=?,id_tipo_transa=?,id_tipo_comprobante=?,id_tipo_transaccion_modulo=?,id_tipo_retencion=?,id_cuenta_contable=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSACCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSACCION_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSACCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSACCION_SELECT(?,?)";
	
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
	
	
	protected TransaccionDataAccessAdditional transaccionDataAccessAdditional=null;
	
	public TransaccionDataAccessAdditional getTransaccionDataAccessAdditional() {
		return this.transaccionDataAccessAdditional;
	}
	
	public void setTransaccionDataAccessAdditional(TransaccionDataAccessAdditional transaccionDataAccessAdditional) {
		try {
			this.transaccionDataAccessAdditional=transaccionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransaccionDataAccess() {
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
		TransaccionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransaccionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransaccionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransaccionOriginal(Transaccion transaccion)throws Exception  {
		transaccion.setTransaccionOriginal((Transaccion)transaccion.clone());		
	}
	
	public void setTransaccionsOriginal(List<Transaccion> transaccions)throws Exception  {
		
		for(Transaccion transaccion:transaccions){
			transaccion.setTransaccionOriginal((Transaccion)transaccion.clone());
		}
	}
	
	public static void setTransaccionOriginalStatic(Transaccion transaccion)throws Exception  {
		transaccion.setTransaccionOriginal((Transaccion)transaccion.clone());		
	}
	
	public static void setTransaccionsOriginalStatic(List<Transaccion> transaccions)throws Exception  {
		
		for(Transaccion transaccion:transaccions){
			transaccion.setTransaccionOriginal((Transaccion)transaccion.clone());
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
	
	public  Transaccion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Transaccion entity = new Transaccion();		
		
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
	
	public  Transaccion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Transaccion entity = new Transaccion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.Transaccion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransaccionOriginal(new Transaccion());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccion("",entity,resultSet); 
				
				//entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Transaccion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transaccion entity = new Transaccion();
				
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
	
	public  Transaccion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transaccion entity = new Transaccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.Transaccion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransaccionOriginal(new Transaccion());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccion("",entity,resultSet);    
				
				//entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Transaccion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Transaccion entity = new Transaccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.Transaccion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransaccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Transaccion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		
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
	
	public  List<Transaccion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transaccion();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccion("",entity,resultSet);
      	    	
				//entity.setTransaccionOriginal( new Transaccion());
      	    	//entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transaccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
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
	
	public  List<Transaccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transaccion();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccion();
					//entity.setMapTransaccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransaccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionDataAccess.getEntityTransaccion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionOriginal( new Transaccion());
					////entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Transaccion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transaccion entity = new Transaccion();		  
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
	
	public  Transaccion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transaccion entity = new Transaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transaccion();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccion();
					//entity.setMapTransaccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransaccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionDataAccess.getEntityTransaccion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionOriginal( new Transaccion());
					////entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransaccion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Transaccion getEntityTransaccion(String strPrefijo,Transaccion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Transaccion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Transaccion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransaccionDataAccess.setFieldReflectionTransaccion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransaccion=TransaccionConstantesFunciones.getTodosTiposColumnasTransaccion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransaccion) {
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
							field = Transaccion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Transaccion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransaccionDataAccess.setFieldReflectionTransaccion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransaccion(Field field,String strPrefijo,String sColumn,Transaccion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransaccionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDTIPOTRANSA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDTIPOCOMPROBANTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transaccion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Transaccion();
					entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransaccion("",entity,resultSet);
					
					//entity.setTransaccionOriginal( new Transaccion());
					//entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
					//entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransaccions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transaccion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Transaccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
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
	
	public  List<Transaccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transaccion();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccion("",entity,resultSet);
      	    	
				//entity.setTransaccionOriginal( new Transaccion());
      	    	//entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransaccions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transaccion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
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
	
	public  List<Transaccion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transaccion> entities = new  ArrayList<Transaccion>();
		Transaccion entity = new Transaccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transaccion();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccion("",entity,resultSet);
      	    	
				//entity.setTransaccionOriginal( new Transaccion());
      	    	//entity.setTransaccionOriginal(super.getEntity("",entity.getTransaccionOriginal(),resultSet,TransaccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionOriginal(this.getEntityTransaccion("",entity.getTransaccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Transaccion getEntityTransaccion(String strPrefijo,Transaccion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDSUCURSAL));
				entity.setcodigo(resultSet.getString(strPrefijo+TransaccionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TransaccionConstantesFunciones.NOMBRE));
				entity.setid_modulo(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDMODULO));
				entity.setid_tipo_transa(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDTIPOTRANSA));
				entity.setid_tipo_comprobante(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDTIPOCOMPROBANTE));if(resultSet.wasNull()) {entity.setid_tipo_comprobante(null); }
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDTIPORETENCION));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+TransaccionConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+TransaccionConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TransaccionConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+TransaccionConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransaccion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Transaccion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransaccionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransaccionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransaccionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransaccionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransaccionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TransaccionDataAccess.TABLENAME,TransaccionDataAccess.ISWITHSTOREPROCEDURES);
			
			TransaccionDataAccess.setTransaccionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltransaccion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltransaccion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltransaccion.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoTransa getTipoTransa(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		TipoTransa tipotransa= new TipoTransa();

		try {
			TipoTransaDataAccess tipotransaDataAccess=new TipoTransaDataAccess();

			tipotransaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaDataAccess.setConnexionType(this.connexionType);
			tipotransaDataAccess.setParameterDbType(this.parameterDbType);

			tipotransa=tipotransaDataAccess.getEntity(connexion,reltransaccion.getid_tipo_transa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransa;

	}

	public TipoComprobante getTipoComprobante(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,reltransaccion.getid_tipo_comprobante());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reltransaccion.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,reltransaccion.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public CuentaContable getCuentaContable(Connexion connexion,Transaccion reltransaccion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltransaccion.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<DetalleCliente> getDetalleClientes(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<DetalleCliente> detalleclientes= new ArrayList<DetalleCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN detallecliente.Transaccion WHERE detallecliente.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleClienteDataAccess detalleclienteDataAccess=new DetalleClienteDataAccess();

			detalleclienteDataAccess.setConnexionType(this.connexionType);
			detalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleclientes;

	}

	public List<ParametroProdu> getParametroProduEgresos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroProdu> parametroproduegresos= new ArrayList<ParametroProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroProduConstantesFunciones.SCHEMA+".parametro_produ.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametroprodu.TransaccionEgreso WHERE parametroprodu.TransaccionEgreso.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroProduDataAccess parametroproduDataAccess=new ParametroProduDataAccess();

			parametroproduDataAccess.setConnexionType(this.connexionType);
			parametroproduDataAccess.setParameterDbType(this.parameterDbType);
			parametroproduegresos=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroproduegresos;

	}

	public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.Transaccion WHERE movimientoinventario.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventarios;

	}

	public List<FormaPago> getFormaPagos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<FormaPago> formapagos= new ArrayList<FormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+FormaPagoConstantesFunciones.SCHEMA+".forma_pago.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN formapago.Transaccion WHERE formapago.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoDataAccess formapagoDataAccess=new FormaPagoDataAccess();

			formapagoDataAccess.setConnexionType(this.connexionType);
			formapagoDataAccess.setParameterDbType(this.parameterDbType);
			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagos;

	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.Transaccion WHERE autoripagoordencompra.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess=new AutoriPagoOrdenCompraDataAccess();

			autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagoordencompras;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN autoripago.Transaccion WHERE autoripago.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoDataAccess autoripagoDataAccess=new AutoriPagoDataAccess();

			autoripagoDataAccess.setConnexionType(this.connexionType);
			autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagos;

	}

	public List<ParametroImpor> getParametroImporIngresos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroImpor> parametroimporingresos= new ArrayList<ParametroImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroImporConstantesFunciones.SCHEMA+".parametro_impor.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametroimpor.TransaccionIngreso WHERE parametroimpor.TransaccionIngreso.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroImporDataAccess parametroimporDataAccess=new ParametroImporDataAccess();

			parametroimporDataAccess.setConnexionType(this.connexionType);
			parametroimporDataAccess.setParameterDbType(this.parameterDbType);
			parametroimporingresos=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroimporingresos;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.Transaccion WHERE facturaproveedor.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<ParametroFactuSecuencial> getParametroFactuSecuencialTransferencias(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroFactuSecuencial> parametrofactusecuencialtransferencias= new ArrayList<ParametroFactuSecuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+".parametro_factu_secuencial.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametrofactusecuencial.TransaccionTransferencia WHERE parametrofactusecuencial.TransaccionTransferencia.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuSecuencialDataAccess parametrofactusecuencialDataAccess=new ParametroFactuSecuencialDataAccess();

			parametrofactusecuencialDataAccess.setConnexionType(this.connexionType);
			parametrofactusecuencialDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactusecuencialtransferencias=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactusecuencialtransferencias;

	}

	public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.Transaccion WHERE facturaproveedorservicio.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<ClienteRetencion> getClienteRetencions(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ClienteRetencion> clienteretencions= new ArrayList<ClienteRetencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ClienteRetencionConstantesFunciones.SCHEMA+".cliente_retencion.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN clienteretencion.Transaccion WHERE clienteretencion.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteRetencionDataAccess clienteretencionDataAccess=new ClienteRetencionDataAccess();

			clienteretencionDataAccess.setConnexionType(this.connexionType);
			clienteretencionDataAccess.setParameterDbType(this.parameterDbType);
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clienteretencions;

	}

	public List<ParametroFactuTransaccion> getParametroFactuTransaccionCuentaCoNotaCreditos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroFactuTransaccion> parametrofactutransaccioncuentaconotacreditos= new ArrayList<ParametroFactuTransaccion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroFactuTransaccionConstantesFunciones.SCHEMA+".parametro_factu_transaccion.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametrofactutransaccion.TransaccionCuentaCoNotaCredito WHERE parametrofactutransaccion.TransaccionCuentaCoNotaCredito.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuTransaccionDataAccess parametrofactutransaccionDataAccess=new ParametroFactuTransaccionDataAccess();

			parametrofactutransaccionDataAccess.setConnexionType(this.connexionType);
			parametrofactutransaccionDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactutransaccioncuentaconotacreditos=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactutransaccioncuentaconotacreditos;

	}

	public List<Definicion> getDefinicions(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN definicion.Transaccion WHERE definicion.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}

	public List<ParametroProducto> getParametroProductos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroProducto> parametroproductos= new ArrayList<ParametroProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroProductoConstantesFunciones.SCHEMA+".parametro_producto.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametroproducto.Transaccion WHERE parametroproducto.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroProductoDataAccess parametroproductoDataAccess=new ParametroProductoDataAccess();

			parametroproductoDataAccess.setConnexionType(this.connexionType);
			parametroproductoDataAccess.setParameterDbType(this.parameterDbType);
			parametroproductos=parametroproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroproductos;

	}

	public List<ParametroCartera> getParametroCarteraHabilitas(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroCartera> parametrocarterahabilitas= new ArrayList<ParametroCartera>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroCarteraConstantesFunciones.SCHEMA+".parametro_cartera.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametrocartera.TransaccionHabilita WHERE parametrocartera.TransaccionHabilita.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCarteraDataAccess parametrocarteraDataAccess=new ParametroCarteraDataAccess();

			parametrocarteraDataAccess.setConnexionType(this.connexionType);
			parametrocarteraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocarterahabilitas=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocarterahabilitas;

	}

	public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.Transaccion WHERE asientocontablecajachica.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachicas;

	}

	public List<ParametroFactuEmpresa> getParametroFactuEmpresaOrigens(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroFactuEmpresa> parametrofactuempresaorigens= new ArrayList<ParametroFactuEmpresa>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+".parametro_factu_empresa.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuempresa.TransaccionOrigen WHERE parametrofactuempresa.TransaccionOrigen.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuEmpresaDataAccess parametrofactuempresaDataAccess=new ParametroFactuEmpresaDataAccess();

			parametrofactuempresaDataAccess.setConnexionType(this.connexionType);
			parametrofactuempresaDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuempresaorigens=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuempresaorigens;

	}

	public List<PagoAuto> getPagoAutos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.Transaccion WHERE pagoauto.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PagoAutoDataAccess pagoautoDataAccess=new PagoAutoDataAccess();

			pagoautoDataAccess.setConnexionType(this.connexionType);
			pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pagoautos;

	}

	public List<ParametroGenerico> getParametroGenericoRecibos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroGenerico> parametrogenericorecibos= new ArrayList<ParametroGenerico>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroGenericoConstantesFunciones.SCHEMA+".parametro_generico.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametrogenerico.TransaccionRecibo WHERE parametrogenerico.TransaccionRecibo.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroGenericoDataAccess parametrogenericoDataAccess=new ParametroGenericoDataAccess();

			parametrogenericoDataAccess.setConnexionType(this.connexionType);
			parametrogenericoDataAccess.setParameterDbType(this.parameterDbType);
			parametrogenericorecibos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrogenericorecibos;

	}

	public List<DetalleProve> getDetalleProves(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<DetalleProve> detalleproves= new ArrayList<DetalleProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN detalleprove.Transaccion WHERE detalleprove.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproves;

	}

	public List<ConfiguracionPunVen> getConfiguracionPunVenCuentaNotaCreditos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ConfiguracionPunVen> configuracionpunvencuentanotacreditos= new ArrayList<ConfiguracionPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ConfiguracionPunVenConstantesFunciones.SCHEMA+".configuracion_pun_ven.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN configuracionpunven.TransaccionCuentaNotaCredito WHERE configuracionpunven.TransaccionCuentaNotaCredito.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConfiguracionPunVenDataAccess configuracionpunvenDataAccess=new ConfiguracionPunVenDataAccess();

			configuracionpunvenDataAccess.setConnexionType(this.connexionType);
			configuracionpunvenDataAccess.setParameterDbType(this.parameterDbType);
			configuracionpunvencuentanotacreditos=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return configuracionpunvencuentanotacreditos;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.Transaccion WHERE ordencompra.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+".detalle_asiento_contable_caja_chica.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontablecajachica.Transaccion WHERE detalleasientocontablecajachica.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess=new DetalleAsientoContableCajaChicaDataAccess();

			detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontablecajachicas;

	}

	public List<CuentaPorCobrar> getCuentaPorCobrars(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<CuentaPorCobrar> cuentaporcobrars= new ArrayList<CuentaPorCobrar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+CuentaPorCobrarConstantesFunciones.SCHEMA+".cuenta_por_cobrar.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN cuentaporcobrar.Transaccion WHERE cuentaporcobrar.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaPorCobrarDataAccess cuentaporcobrarDataAccess=new CuentaPorCobrarDataAccess();

			cuentaporcobrarDataAccess.setConnexionType(this.connexionType);
			cuentaporcobrarDataAccess.setParameterDbType(this.parameterDbType);
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentaporcobrars;

	}

	public List<DetalleMoviClienProve> getDetalleMoviClienProves(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<DetalleMoviClienProve> detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+DetalleMoviClienProveConstantesFunciones.SCHEMA+".detalle_movi_clien_prove.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN detallemoviclienprove.Transaccion WHERE detallemoviclienprove.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMoviClienProveDataAccess detallemoviclienproveDataAccess=new DetalleMoviClienProveDataAccess();

			detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemoviclienproves;

	}

	public List<ParametroTesoreria> getParametroTesoreriaPagarPagos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<ParametroTesoreria> parametrotesoreriapagarpagos= new ArrayList<ParametroTesoreria>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+ParametroTesoreriaConstantesFunciones.SCHEMA+".parametro_tesoreria.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN parametrotesoreria.TransaccionPagarPago WHERE parametrotesoreria.TransaccionPagarPago.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroTesoreriaDataAccess parametrotesoreriaDataAccess=new ParametroTesoreriaDataAccess();

			parametrotesoreriaDataAccess.setConnexionType(this.connexionType);
			parametrotesoreriaDataAccess.setParameterDbType(this.parameterDbType);
			parametrotesoreriapagarpagos=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrotesoreriapagarpagos;

	}

	public List<TransaccionIngresoEgreso> getTransaccionIngresoEgresos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<TransaccionIngresoEgreso> transaccioningresoegresos= new ArrayList<TransaccionIngresoEgreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+".transaccion_ingreso_egreso.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN transaccioningresoegreso.Transaccion WHERE transaccioningresoegreso.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionIngresoEgresoDataAccess transaccioningresoegresoDataAccess=new TransaccionIngresoEgresoDataAccess();

			transaccioningresoegresoDataAccess.setConnexionType(this.connexionType);
			transaccioningresoegresoDataAccess.setParameterDbType(this.parameterDbType);
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccioningresoegresos;

	}

	public List<TransaccionCliente> getTransaccionCliente2s(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<TransaccionCliente> transaccioncliente2s= new ArrayList<TransaccionCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+TransaccionClienteConstantesFunciones.SCHEMA+".transaccion_cliente.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN transaccioncliente.Transaccion2 WHERE transaccioncliente.Transaccion2.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionClienteDataAccess transaccionclienteDataAccess=new TransaccionClienteDataAccess();

			transaccionclienteDataAccess.setConnexionType(this.connexionType);
			transaccionclienteDataAccess.setParameterDbType(this.parameterDbType);
			transaccioncliente2s=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccioncliente2s;

	}

	public List<TipoFormaPago> getTipoFormaPagos(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<TipoFormaPago> tipoformapagos= new ArrayList<TipoFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN tipoformapago.Transaccion WHERE tipoformapago.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapagos;

	}

	public List<AnalisisTransaCliente> getAnalisisTransaClientes(Connexion connexion,Transaccion transaccion)throws SQLException,Exception {

		List<AnalisisTransaCliente> analisistransaclientes= new ArrayList<AnalisisTransaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionConstantesFunciones.SCHEMA+".transaccion ON "+AnalisisTransaClienteConstantesFunciones.SCHEMA+".analisis_transa_cliente.id_transaccion="+TransaccionConstantesFunciones.SCHEMA+".transaccion.id WHERE "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id="+String.valueOf(transaccion.getId());
			} else {
				sQuery=" INNER JOIN analisistransacliente.Transaccion WHERE analisistransacliente.Transaccion.id="+String.valueOf(transaccion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AnalisisTransaClienteDataAccess analisistransaclienteDataAccess=new AnalisisTransaClienteDataAccess();

			analisistransaclienteDataAccess.setConnexionType(this.connexionType);
			analisistransaclienteDataAccess.setParameterDbType(this.parameterDbType);
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return analisistransaclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Transaccion transaccion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transaccion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(transaccion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(transaccion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(transaccion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(transaccion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(transaccion.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transa.setValue(transaccion.getid_tipo_transa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_comprobante=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_comprobante.setValue(transaccion.getid_tipo_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(transaccion.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(transaccion.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(transaccion.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(transaccion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!transaccion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transaccion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transaccion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transaccion.getId());
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
	
	public void setIsNewIsChangedFalseTransaccion(Transaccion transaccion)throws Exception  {		
		transaccion.setIsNew(false);
		transaccion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransaccions(List<Transaccion> transaccions)throws Exception  {				
		for(Transaccion transaccion:transaccions) {
			transaccion.setIsNew(false);
			transaccion.setIsChanged(false);
		}
	}
	
	public void generarExportarTransaccion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
