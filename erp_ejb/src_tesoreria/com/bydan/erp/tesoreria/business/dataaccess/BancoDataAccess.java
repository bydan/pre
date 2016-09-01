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
import com.bydan.erp.tesoreria.util.*;//BancoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class BancoDataAccess extends  BancoDataAccessAdditional{ //BancoDataAccessAdditional,DataAccessHelper<Banco>
	//static Logger logger = Logger.getLogger(BancoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="banco";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,codigo,codigo_institucion,nombre,id_tipo_banco,dias_efectivo_local,dias_efectivo_extranjero,id_cuenta_contable_debito,id_cuenta_contable_credito,delimitador,id_formato1,id_formato2)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,codigo_institucion=?,nombre=?,id_tipo_banco=?,dias_efectivo_local=?,dias_efectivo_extranjero=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,delimitador=?,id_formato1=?,id_formato2=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select banco from "+BancoConstantesFunciones.SPERSISTENCENAME+" banco";
	public static String QUERYSELECTNATIVE="select "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".version_row,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_empresa,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_sucursal,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".codigo,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".codigo_institucion,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".nombre,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_tipo_banco,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".dias_efectivo_local,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".dias_efectivo_extranjero,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".delimitador,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_formato1,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id_formato2 from "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME;//+" as "+BancoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".id,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".version_row,"+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+".nombre from "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME;//+" as "+BancoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+BancoConstantesFunciones.SCHEMA+"."+BancoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,codigo_institucion=?,nombre=?,id_tipo_banco=?,dias_efectivo_local=?,dias_efectivo_extranjero=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,delimitador=?,id_formato1=?,id_formato2=?";
	
	public static String STOREPROCEDUREINSERT="call SP_BANCO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_BANCO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_BANCO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_BANCO_SELECT(?,?)";
	
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
	
	
	protected BancoDataAccessAdditional bancoDataAccessAdditional=null;
	
	public BancoDataAccessAdditional getBancoDataAccessAdditional() {
		return this.bancoDataAccessAdditional;
	}
	
	public void setBancoDataAccessAdditional(BancoDataAccessAdditional bancoDataAccessAdditional) {
		try {
			this.bancoDataAccessAdditional=bancoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public BancoDataAccess() {
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
		BancoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		BancoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		BancoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setBancoOriginal(Banco banco)throws Exception  {
		banco.setBancoOriginal((Banco)banco.clone());		
	}
	
	public void setBancosOriginal(List<Banco> bancos)throws Exception  {
		
		for(Banco banco:bancos){
			banco.setBancoOriginal((Banco)banco.clone());
		}
	}
	
	public static void setBancoOriginalStatic(Banco banco)throws Exception  {
		banco.setBancoOriginal((Banco)banco.clone());		
	}
	
	public static void setBancosOriginalStatic(List<Banco> bancos)throws Exception  {
		
		for(Banco banco:bancos){
			banco.setBancoOriginal((Banco)banco.clone());
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
	
	public  Banco getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Banco entity = new Banco();		
		
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
	
	public  Banco getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Banco entity = new Banco();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.Banco.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setBancoOriginal(new Banco());
      	    	entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBanco("",entity,resultSet); 
				
				//entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseBanco(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Banco getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Banco entity = new Banco();
				
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
	
	public  Banco getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Banco entity = new Banco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.Banco.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setBancoOriginal(new Banco());
      	    	entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBanco("",entity,resultSet);    
				
				//entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Banco
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Banco entity = new Banco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.Banco.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Banco> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		
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
	
	public  List<Banco> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Banco();
      	    	entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBanco("",entity,resultSet);
      	    	
				//entity.setBancoOriginal( new Banco());
      	    	//entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Banco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
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
	
	public  List<Banco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Banco();
				
				if(conMapGenerico) {
					entity.inicializarMapBanco();
					//entity.setMapBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         		
					entity=BancoDataAccess.getEntityBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBancoOriginal( new Banco());
					////entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
					////entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Banco getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Banco entity = new Banco();		  
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
	
	public  Banco getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Banco entity = new Banco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Banco();
				
				if(conMapGenerico) {
					entity.inicializarMapBanco();
					//entity.setMapBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         		
					entity=BancoDataAccess.getEntityBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBancoOriginal( new Banco());
					////entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
					////entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseBanco(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Banco getEntityBanco(String strPrefijo,Banco entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Banco.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Banco.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					BancoDataAccess.setFieldReflectionBanco(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasBanco=BancoConstantesFunciones.getTodosTiposColumnasBanco();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasBanco) {
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
							field = Banco.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Banco.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						BancoDataAccess.setFieldReflectionBanco(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBanco(Field field,String strPrefijo,String sColumn,Banco entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BancoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoConstantesFunciones.CODIGOINSTITUCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoConstantesFunciones.IDTIPOBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.DIASEFECTIVOLOCAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BancoConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.DELIMITADOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoConstantesFunciones.IDFORMATO1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoConstantesFunciones.IDFORMATO2:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Banco>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Banco();
					entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityBanco("",entity,resultSet);
					
					//entity.setBancoOriginal( new Banco());
					//entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
					//entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseBancos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Banco>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Banco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
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
	
	public  List<Banco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Banco();
      	    	entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBanco("",entity,resultSet);
      	    	
				//entity.setBancoOriginal( new Banco());
      	    	//entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseBancos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Banco> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
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
	
	public  List<Banco> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Banco> entities = new  ArrayList<Banco>();
		Banco entity = new Banco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Banco();
      	    	entity=super.getEntity("",entity,resultSet,BancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBanco("",entity,resultSet);
      	    	
				//entity.setBancoOriginal( new Banco());
      	    	//entity.setBancoOriginal(super.getEntity("",entity.getBancoOriginal(),resultSet,BancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoOriginal(this.getEntityBanco("",entity.getBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Banco getEntityBanco(String strPrefijo,Banco entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDSUCURSAL));
				entity.setcodigo(resultSet.getString(strPrefijo+BancoConstantesFunciones.CODIGO));
				entity.setcodigo_institucion(resultSet.getString(strPrefijo+BancoConstantesFunciones.CODIGOINSTITUCION));
				entity.setnombre(resultSet.getString(strPrefijo+BancoConstantesFunciones.NOMBRE));
				entity.setid_tipo_banco(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDTIPOBANCO));
				entity.setdias_efectivo_local(resultSet.getInt(strPrefijo+BancoConstantesFunciones.DIASEFECTIVOLOCAL));
				entity.setdias_efectivo_extranjero(resultSet.getInt(strPrefijo+BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDCUENTACONTABLEDEBITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_debito(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setdelimitador(resultSet.getString(strPrefijo+BancoConstantesFunciones.DELIMITADOR));
				entity.setid_formato1(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDFORMATO1));if(resultSet.wasNull()) {entity.setid_formato1(null); }
				entity.setid_formato2(resultSet.getLong(strPrefijo+BancoConstantesFunciones.IDFORMATO2));if(resultSet.wasNull()) {entity.setid_formato2(null); }
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+BancoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowBanco(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Banco entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=BancoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=BancoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=BancoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=BancoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(BancoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,BancoDataAccess.TABLENAME,BancoDataAccess.ISWITHSTOREPROCEDURES);
			
			BancoDataAccess.setBancoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relbanco.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relbanco.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoBanco getTipoBanco(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		TipoBanco tipobanco= new TipoBanco();

		try {
			TipoBancoDataAccess tipobancoDataAccess=new TipoBancoDataAccess();

			tipobancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipobancoDataAccess.setConnexionType(this.connexionType);
			tipobancoDataAccess.setParameterDbType(this.parameterDbType);

			tipobanco=tipobancoDataAccess.getEntity(connexion,relbanco.getid_tipo_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipobanco;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbanco.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbanco.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Formato getFormato1(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relbanco.getid_formato1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormato2(Connexion connexion,Banco relbanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relbanco.getid_formato2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
		public List<CuentaBancoPunVen> getCuentaBancoPunVens(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<CuentaBancoPunVen> cuentabancopunvens= new ArrayList<CuentaBancoPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+CuentaBancoPunVenConstantesFunciones.SCHEMA+".cuenta_banco_pun_ven.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN cuentabancopunven.Banco WHERE cuentabancopunven.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaBancoPunVenDataAccess cuentabancopunvenDataAccess=new CuentaBancoPunVenDataAccess();

			cuentabancopunvenDataAccess.setConnexionType(this.connexionType);
			cuentabancopunvenDataAccess.setParameterDbType(this.parameterDbType);
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabancopunvens;

	}

	public List<PoliticasCliente> getPoliticasClientes(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<PoliticasCliente> politicasclientes= new ArrayList<PoliticasCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+PoliticasClienteConstantesFunciones.SCHEMA+".politicas_cliente.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN politicascliente.Banco WHERE politicascliente.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticasClienteDataAccess politicasclienteDataAccess=new PoliticasClienteDataAccess();

			politicasclienteDataAccess.setConnexionType(this.connexionType);
			politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicasclientes;

	}

	public List<FormularioRentaExtra> getFormularioRentaExtras(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<FormularioRentaExtra> formulariorentaextras= new ArrayList<FormularioRentaExtra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+FormularioRentaExtraConstantesFunciones.SCHEMA+".formulario_renta_extra.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN formulariorentaextra.Banco WHERE formulariorentaextra.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioRentaExtraDataAccess formulariorentaextraDataAccess=new FormularioRentaExtraDataAccess();

			formulariorentaextraDataAccess.setConnexionType(this.connexionType);
			formulariorentaextraDataAccess.setParameterDbType(this.parameterDbType);
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formulariorentaextras;

	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<DatoGeneralEmpleado> datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.Banco WHERE datogeneralempleado.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleados;

	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.Banco WHERE formapagopuntoventa.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.Banco WHERE autoripagoordencompra.Banco.id="+String.valueOf(banco.getId());

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

	public List<ReciboPuntoVenta> getReciboPuntoVentas(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<ReciboPuntoVenta> recibopuntoventas= new ArrayList<ReciboPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+ReciboPuntoVentaConstantesFunciones.SCHEMA+".recibo_punto_venta.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN recibopuntoventa.Banco WHERE recibopuntoventa.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReciboPuntoVentaDataAccess recibopuntoventaDataAccess=new ReciboPuntoVentaDataAccess();

			recibopuntoventaDataAccess.setConnexionType(this.connexionType);
			recibopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return recibopuntoventas;

	}

	public List<TarjetaCredito> getTarjetaCreditos(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<TarjetaCredito> tarjetacreditos= new ArrayList<TarjetaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN tarjetacredito.Banco WHERE tarjetacredito.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacreditos;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN autoripago.Banco WHERE autoripago.Banco.id="+String.valueOf(banco.getId());

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

	public List<TipoCuentaBancoGeneral> getTipoCuentaBancoGenerals(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<TipoCuentaBancoGeneral> tipocuentabancogenerals= new ArrayList<TipoCuentaBancoGeneral>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+".tipo_cuenta_banco_general.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN tipocuentabancogeneral.Banco WHERE tipocuentabancogeneral.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoCuentaBancoGeneralDataAccess tipocuentabancogeneralDataAccess=new TipoCuentaBancoGeneralDataAccess();

			tipocuentabancogeneralDataAccess.setConnexionType(this.connexionType);
			tipocuentabancogeneralDataAccess.setParameterDbType(this.parameterDbType);
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabancogenerals;

	}

	public List<ReferenciaBancaria> getReferenciaBancarias(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<ReferenciaBancaria> referenciabancarias= new ArrayList<ReferenciaBancaria>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+ReferenciaBancariaConstantesFunciones.SCHEMA+".referenciabancaria.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN referenciabancaria.Banco WHERE referenciabancaria.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReferenciaBancariaDataAccess referenciabancariaDataAccess=new ReferenciaBancariaDataAccess();

			referenciabancariaDataAccess.setConnexionType(this.connexionType);
			referenciabancariaDataAccess.setParameterDbType(this.parameterDbType);
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return referenciabancarias;

	}

	public List<DepositoBanco> getDepositoBancos(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<DepositoBanco> depositobancos= new ArrayList<DepositoBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+DepositoBancoConstantesFunciones.SCHEMA+".deposito_banco.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN depositobanco.Banco WHERE depositobanco.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DepositoBancoDataAccess depositobancoDataAccess=new DepositoBancoDataAccess();

			depositobancoDataAccess.setConnexionType(this.connexionType);
			depositobancoDataAccess.setParameterDbType(this.parameterDbType);
			depositobancos=depositobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return depositobancos;

	}

	public List<BancoTipoCuentaBancoGlobal> getBancoTipoCuentaBancoGlobals(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals= new ArrayList<BancoTipoCuentaBancoGlobal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".banco_tipo_cuenta_banco_global.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN bancotipocuentabancoglobal.Banco WHERE bancotipocuentabancoglobal.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BancoTipoCuentaBancoGlobalDataAccess bancotipocuentabancoglobalDataAccess=new BancoTipoCuentaBancoGlobalDataAccess();

			bancotipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			bancotipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bancotipocuentabancoglobals;

	}

	public List<CuentaBanco> getCuentaBancos(Connexion connexion,Banco banco)throws SQLException,Exception {

		List<CuentaBanco> cuentabancos= new ArrayList<CuentaBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+BancoConstantesFunciones.SCHEMA+".banco ON "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id_banco="+BancoConstantesFunciones.SCHEMA+".banco.id WHERE "+BancoConstantesFunciones.SCHEMA+".banco.id="+String.valueOf(banco.getId());
			} else {
				sQuery=" INNER JOIN cuentabanco.Banco WHERE cuentabanco.Banco.id="+String.valueOf(banco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabancos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Banco banco) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!banco.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(banco.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(banco.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(banco.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_institucion=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_institucion.setValue(banco.getcodigo_institucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_institucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(banco.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_banco.setValue(banco.getid_tipo_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedias_efectivo_local=new ParameterValue<Integer>();
					parameterMaintenanceValuedias_efectivo_local.setValue(banco.getdias_efectivo_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_efectivo_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedias_efectivo_extranjero=new ParameterValue<Integer>();
					parameterMaintenanceValuedias_efectivo_extranjero.setValue(banco.getdias_efectivo_extranjero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_efectivo_extranjero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(banco.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(banco.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedelimitador=new ParameterValue<String>();
					parameterMaintenanceValuedelimitador.setValue(banco.getdelimitador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedelimitador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato1=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato1.setValue(banco.getid_formato1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato2=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato2.setValue(banco.getid_formato2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato2);
					parametersTemp.add(parameterMaintenance);
					
						if(!banco.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(banco.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(banco.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(banco.getId());
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
	
	public void setIsNewIsChangedFalseBanco(Banco banco)throws Exception  {		
		banco.setIsNew(false);
		banco.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseBancos(List<Banco> bancos)throws Exception  {				
		for(Banco banco:bancos) {
			banco.setIsNew(false);
			banco.setIsChanged(false);
		}
	}
	
	public void generarExportarBanco(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
