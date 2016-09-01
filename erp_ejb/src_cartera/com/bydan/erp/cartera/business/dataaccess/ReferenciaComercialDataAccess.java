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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//ReferenciaComercialConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ReferenciaComercialDataAccess extends  ReferenciaComercialDataAccessAdditional{ //ReferenciaComercialDataAccessAdditional,DataAccessHelper<ReferenciaComercial>
	//static Logger logger = Logger.getLogger(ReferenciaComercialDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="referenciacomercial";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+"(version_row,id_empresa,idcliente,idvalorclientesectoreconomico,id_pais,idciudad,nombreempresa,codigo_cliente,contacto,articulo_compra,numero_anios,numero_meses,id_tipo_valoracion,direccion,telefono,telefonomovil,telefonocodigoarea,email,monto,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientesectoreconomico=?,id_pais=?,idciudad=?,nombreempresa=?,codigo_cliente=?,contacto=?,articulo_compra=?,numero_anios=?,numero_meses=?,id_tipo_valoracion=?,direccion=?,telefono=?,telefonomovil=?,telefonocodigoarea=?,email=?,monto=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select referenciacomercial from "+ReferenciaComercialConstantesFunciones.SPERSISTENCENAME+" referenciacomercial";
	public static String QUERYSELECTNATIVE="select "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".version_row,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".idcliente,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".idvalorclientesectoreconomico,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id_pais,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".idciudad,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".nombreempresa,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".codigo_cliente,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".contacto,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".articulo_compra,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".numero_anios,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".numero_meses,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".direccion,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".telefono,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".telefonomovil,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".telefonocodigoarea,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".email,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".monto,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".esactivo from "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME;//+" as "+ReferenciaComercialConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".version_row from "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME;//+" as "+ReferenciaComercialConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientesectoreconomico=?,id_pais=?,idciudad=?,nombreempresa=?,codigo_cliente=?,contacto=?,articulo_compra=?,numero_anios=?,numero_meses=?,id_tipo_valoracion=?,direccion=?,telefono=?,telefonomovil=?,telefonocodigoarea=?,email=?,monto=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REFERENCIACOMERCIAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REFERENCIACOMERCIAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REFERENCIACOMERCIAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REFERENCIACOMERCIAL_SELECT(?,?)";
	
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
	
	
	protected ReferenciaComercialDataAccessAdditional referenciacomercialDataAccessAdditional=null;
	
	public ReferenciaComercialDataAccessAdditional getReferenciaComercialDataAccessAdditional() {
		return this.referenciacomercialDataAccessAdditional;
	}
	
	public void setReferenciaComercialDataAccessAdditional(ReferenciaComercialDataAccessAdditional referenciacomercialDataAccessAdditional) {
		try {
			this.referenciacomercialDataAccessAdditional=referenciacomercialDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ReferenciaComercialDataAccess() {
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
		ReferenciaComercialDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ReferenciaComercialDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ReferenciaComercialDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setReferenciaComercialOriginal(ReferenciaComercial referenciacomercial)throws Exception  {
		referenciacomercial.setReferenciaComercialOriginal((ReferenciaComercial)referenciacomercial.clone());		
	}
	
	public void setReferenciaComercialsOriginal(List<ReferenciaComercial> referenciacomercials)throws Exception  {
		
		for(ReferenciaComercial referenciacomercial:referenciacomercials){
			referenciacomercial.setReferenciaComercialOriginal((ReferenciaComercial)referenciacomercial.clone());
		}
	}
	
	public static void setReferenciaComercialOriginalStatic(ReferenciaComercial referenciacomercial)throws Exception  {
		referenciacomercial.setReferenciaComercialOriginal((ReferenciaComercial)referenciacomercial.clone());		
	}
	
	public static void setReferenciaComercialsOriginalStatic(List<ReferenciaComercial> referenciacomercials)throws Exception  {
		
		for(ReferenciaComercial referenciacomercial:referenciacomercials){
			referenciacomercial.setReferenciaComercialOriginal((ReferenciaComercial)referenciacomercial.clone());
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
	
	public  ReferenciaComercial getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ReferenciaComercial entity = new ReferenciaComercial();		
		
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
	
	public  ReferenciaComercial getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ReferenciaComercial entity = new ReferenciaComercial();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ReferenciaComercial.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setReferenciaComercialOriginal(new ReferenciaComercial());
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReferenciaComercial("",entity,resultSet); 
				
				//entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseReferenciaComercial(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ReferenciaComercial getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReferenciaComercial entity = new ReferenciaComercial();
				
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
	
	public  ReferenciaComercial getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReferenciaComercial entity = new ReferenciaComercial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaComercialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ReferenciaComercial.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setReferenciaComercialOriginal(new ReferenciaComercial());
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReferenciaComercial("",entity,resultSet);    
				
				//entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseReferenciaComercial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ReferenciaComercial
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ReferenciaComercial entity = new ReferenciaComercial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaComercialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ReferenciaComercial.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseReferenciaComercial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ReferenciaComercial> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		
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
	
	public  List<ReferenciaComercial> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaComercialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaComercial();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaComercial("",entity,resultSet);
      	    	
				//entity.setReferenciaComercialOriginal( new ReferenciaComercial());
      	    	//entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaComercials(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaComercial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReferenciaComercial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
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
	
	public  List<ReferenciaComercial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaComercial();
				
				if(conMapGenerico) {
					entity.inicializarMapReferenciaComercial();
					//entity.setMapReferenciaComercial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapReferenciaComercialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReferenciaComercial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         		
					entity=ReferenciaComercialDataAccess.getEntityReferenciaComercial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReferenciaComercialOriginal( new ReferenciaComercial());
					////entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
					////entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaComercials(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaComercial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ReferenciaComercial getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReferenciaComercial entity = new ReferenciaComercial();		  
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
	
	public  ReferenciaComercial getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaComercial();
				
				if(conMapGenerico) {
					entity.inicializarMapReferenciaComercial();
					//entity.setMapReferenciaComercial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapReferenciaComercialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReferenciaComercial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         		
					entity=ReferenciaComercialDataAccess.getEntityReferenciaComercial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReferenciaComercialOriginal( new ReferenciaComercial());
					////entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
					////entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseReferenciaComercial(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaComercial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ReferenciaComercial getEntityReferenciaComercial(String strPrefijo,ReferenciaComercial entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ReferenciaComercial.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ReferenciaComercial.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ReferenciaComercialDataAccess.setFieldReflectionReferenciaComercial(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasReferenciaComercial=ReferenciaComercialConstantesFunciones.getTodosTiposColumnasReferenciaComercial();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasReferenciaComercial) {
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
							field = ReferenciaComercial.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ReferenciaComercial.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ReferenciaComercialDataAccess.setFieldReflectionReferenciaComercial(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionReferenciaComercial(Field field,String strPrefijo,String sColumn,ReferenciaComercial entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ReferenciaComercialConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.NOMBREEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.CONTACTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.NUMEROANIOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.NUMEROMESES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.IDTIPOVALORACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.TELEFONOMOVIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ReferenciaComercialConstantesFunciones.ESACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReferenciaComercial>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaComercialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ReferenciaComercial();
					entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityReferenciaComercial("",entity,resultSet);
					
					//entity.setReferenciaComercialOriginal( new ReferenciaComercial());
					//entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
					//entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseReferenciaComercials(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaComercial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReferenciaComercial>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaComercialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaComercialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ReferenciaComercial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
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
	
	public  List<ReferenciaComercial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaComercial();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaComercial("",entity,resultSet);
      	    	
				//entity.setReferenciaComercialOriginal( new ReferenciaComercial());
      	    	//entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseReferenciaComercials(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaComercial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReferenciaComercial> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
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
	
	public  List<ReferenciaComercial> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaComercial> entities = new  ArrayList<ReferenciaComercial>();
		ReferenciaComercial entity = new ReferenciaComercial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaComercial();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaComercial("",entity,resultSet);
      	    	
				//entity.setReferenciaComercialOriginal( new ReferenciaComercial());
      	    	//entity.setReferenciaComercialOriginal(super.getEntity("",entity.getReferenciaComercialOriginal(),resultSet,ReferenciaComercialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaComercialOriginal(this.getEntityReferenciaComercial("",entity.getReferenciaComercialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaComercials(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ReferenciaComercial getEntityReferenciaComercial(String strPrefijo,ReferenciaComercial entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ReferenciaComercialConstantesFunciones.IDEMPRESA));
				entity.setidcliente(resultSet.getLong(strPrefijo+ReferenciaComercialConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientesectoreconomico(resultSet.getLong(strPrefijo+ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO));
				entity.setid_pais(resultSet.getLong(strPrefijo+ReferenciaComercialConstantesFunciones.IDPAIS));
				entity.setidciudad(resultSet.getLong(strPrefijo+ReferenciaComercialConstantesFunciones.IDCIUDAD));
				entity.setnombreempresa(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.NOMBREEMPRESA));
				entity.setcodigo_cliente(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.CODIGOCLIENTE));
				entity.setcontacto(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.CONTACTO));
				entity.setarticulo_compra(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA));
				entity.setnumero_anios(resultSet.getInt(strPrefijo+ReferenciaComercialConstantesFunciones.NUMEROANIOS));
				entity.setnumero_meses(resultSet.getInt(strPrefijo+ReferenciaComercialConstantesFunciones.NUMEROMESES));
				entity.setid_tipo_valoracion(resultSet.getLong(strPrefijo+ReferenciaComercialConstantesFunciones.IDTIPOVALORACION));
				entity.setdireccion(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.TELEFONO));
				entity.settelefonomovil(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.TELEFONOMOVIL));
				entity.settelefonocodigoarea(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA));
				entity.setemail(resultSet.getString(strPrefijo+ReferenciaComercialConstantesFunciones.EMAIL));
				entity.setmonto(resultSet.getDouble(strPrefijo+ReferenciaComercialConstantesFunciones.MONTO));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+ReferenciaComercialConstantesFunciones.ESACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowReferenciaComercial(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ReferenciaComercial entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ReferenciaComercialDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ReferenciaComercialDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ReferenciaComercialDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ReferenciaComercialDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ReferenciaComercialConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ReferenciaComercialDataAccess.TABLENAME,ReferenciaComercialDataAccess.ISWITHSTOREPROCEDURES);
			
			ReferenciaComercialDataAccess.setReferenciaComercialOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ReferenciaComercial relreferenciacomercial)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relreferenciacomercial.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,ReferenciaComercial relreferenciacomercial)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relreferenciacomercial.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoSectorEcono getTipoSectorEcono(Connexion connexion,ReferenciaComercial relreferenciacomercial)throws SQLException,Exception {

		TipoSectorEcono tiposectorecono= new TipoSectorEcono();

		try {
			TipoSectorEconoDataAccess tiposectoreconoDataAccess=new TipoSectorEconoDataAccess();

			tiposectoreconoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiposectoreconoDataAccess.setConnexionType(this.connexionType);
			tiposectoreconoDataAccess.setParameterDbType(this.parameterDbType);

			tiposectorecono=tiposectoreconoDataAccess.getEntity(connexion,relreferenciacomercial.getidvalorclientesectoreconomico());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiposectorecono;

	}

	public Pais getPais(Connexion connexion,ReferenciaComercial relreferenciacomercial)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relreferenciacomercial.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,ReferenciaComercial relreferenciacomercial)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relreferenciacomercial.getidciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public TipoValoracion getTipoValoracion(Connexion connexion,ReferenciaComercial relreferenciacomercial)throws SQLException,Exception {

		TipoValoracion tipovaloracion= new TipoValoracion();

		try {
			TipoValoracionDataAccess tipovaloracionDataAccess=new TipoValoracionDataAccess();

			tipovaloracionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovaloracionDataAccess.setConnexionType(this.connexionType);
			tipovaloracionDataAccess.setParameterDbType(this.parameterDbType);

			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion,relreferenciacomercial.getid_tipo_valoracion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovaloracion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ReferenciaComercial referenciacomercial) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!referenciacomercial.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(referenciacomercial.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(referenciacomercial.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientesectoreconomico=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientesectoreconomico.setValue(referenciacomercial.getidvalorclientesectoreconomico());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientesectoreconomico);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(referenciacomercial.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidciudad=new ParameterValue<Long>();
					parameterMaintenanceValueidciudad.setValue(referenciacomercial.getidciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombreempresa=new ParameterValue<String>();
					parameterMaintenanceValuenombreempresa.setValue(referenciacomercial.getnombreempresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombreempresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_cliente=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_cliente.setValue(referenciacomercial.getcodigo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontacto=new ParameterValue<String>();
					parameterMaintenanceValuecontacto.setValue(referenciacomercial.getcontacto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontacto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuearticulo_compra=new ParameterValue<String>();
					parameterMaintenanceValuearticulo_compra.setValue(referenciacomercial.getarticulo_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearticulo_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_anios=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_anios.setValue(referenciacomercial.getnumero_anios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_anios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_meses=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_meses.setValue(referenciacomercial.getnumero_meses());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_meses);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_valoracion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_valoracion.setValue(referenciacomercial.getid_tipo_valoracion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_valoracion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(referenciacomercial.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(referenciacomercial.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonomovil=new ParameterValue<String>();
					parameterMaintenanceValuetelefonomovil.setValue(referenciacomercial.gettelefonomovil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonomovil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonocodigoarea=new ParameterValue<String>();
					parameterMaintenanceValuetelefonocodigoarea.setValue(referenciacomercial.gettelefonocodigoarea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonocodigoarea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueemail=new ParameterValue<String>();
					parameterMaintenanceValueemail.setValue(referenciacomercial.getemail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto=new ParameterValue<Double>();
					parameterMaintenanceValuemonto.setValue(referenciacomercial.getmonto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(referenciacomercial.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!referenciacomercial.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(referenciacomercial.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(referenciacomercial.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(referenciacomercial.getId());
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
	
	public void setIsNewIsChangedFalseReferenciaComercial(ReferenciaComercial referenciacomercial)throws Exception  {		
		referenciacomercial.setIsNew(false);
		referenciacomercial.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseReferenciaComercials(List<ReferenciaComercial> referenciacomercials)throws Exception  {				
		for(ReferenciaComercial referenciacomercial:referenciacomercials) {
			referenciacomercial.setIsNew(false);
			referenciacomercial.setIsChanged(false);
		}
	}
	
	public void generarExportarReferenciaComercial(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
