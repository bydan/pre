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
import com.bydan.erp.tesoreria.util.*;//RegistroFormaPagoBancoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class RegistroFormaPagoBancoDataAccess extends  RegistroFormaPagoBancoDataAccessAdditional{ //RegistroFormaPagoBancoDataAccessAdditional,DataAccessHelper<RegistroFormaPagoBanco>
	//static Logger logger = Logger.getLogger(RegistroFormaPagoBancoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="registro_forma_pago_banco";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_asiento_contable,id_tipo_forma_pago,id_estado_registro_forma_pago_banco,id_cliente,nombre_banco,nombre_girador,fecha_vencimiento,numero_cuenta,numero_cheque,valor_monto,fecha,fecha_vencimiento_original,numero_cambio,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_asiento_contable=?,id_tipo_forma_pago=?,id_estado_registro_forma_pago_banco=?,id_cliente=?,nombre_banco=?,nombre_girador=?,fecha_vencimiento=?,numero_cuenta=?,numero_cheque=?,valor_monto=?,fecha=?,fecha_vencimiento_original=?,numero_cambio=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select registroformapagobanco from "+RegistroFormaPagoBancoConstantesFunciones.SPERSISTENCENAME+" registroformapagobanco";
	public static String QUERYSELECTNATIVE="select "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".version_row,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_empresa,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_sucursal,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_ejercicio,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_periodo,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_asiento_contable,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_estado_registro_forma_pago_banco,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_cliente,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".nombre_banco,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".nombre_girador,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".numero_cuenta,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".numero_cheque,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".valor_monto,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".fecha,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".fecha_vencimiento_original,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".numero_cambio,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_anio,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_mes from "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME;//+" as "+RegistroFormaPagoBancoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".version_row from "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME;//+" as "+RegistroFormaPagoBancoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_asiento_contable=?,id_tipo_forma_pago=?,id_estado_registro_forma_pago_banco=?,id_cliente=?,nombre_banco=?,nombre_girador=?,fecha_vencimiento=?,numero_cuenta=?,numero_cheque=?,valor_monto=?,fecha=?,fecha_vencimiento_original=?,numero_cambio=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REGISTROFORMAPAGOBANCO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REGISTROFORMAPAGOBANCO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REGISTROFORMAPAGOBANCO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REGISTROFORMAPAGOBANCO_SELECT(?,?)";
	
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
	
	
	protected RegistroFormaPagoBancoDataAccessAdditional registroformapagobancoDataAccessAdditional=null;
	
	public RegistroFormaPagoBancoDataAccessAdditional getRegistroFormaPagoBancoDataAccessAdditional() {
		return this.registroformapagobancoDataAccessAdditional;
	}
	
	public void setRegistroFormaPagoBancoDataAccessAdditional(RegistroFormaPagoBancoDataAccessAdditional registroformapagobancoDataAccessAdditional) {
		try {
			this.registroformapagobancoDataAccessAdditional=registroformapagobancoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RegistroFormaPagoBancoDataAccess() {
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
		RegistroFormaPagoBancoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RegistroFormaPagoBancoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RegistroFormaPagoBancoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRegistroFormaPagoBancoOriginal(RegistroFormaPagoBanco registroformapagobanco)throws Exception  {
		registroformapagobanco.setRegistroFormaPagoBancoOriginal((RegistroFormaPagoBanco)registroformapagobanco.clone());		
	}
	
	public void setRegistroFormaPagoBancosOriginal(List<RegistroFormaPagoBanco> registroformapagobancos)throws Exception  {
		
		for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos){
			registroformapagobanco.setRegistroFormaPagoBancoOriginal((RegistroFormaPagoBanco)registroformapagobanco.clone());
		}
	}
	
	public static void setRegistroFormaPagoBancoOriginalStatic(RegistroFormaPagoBanco registroformapagobanco)throws Exception  {
		registroformapagobanco.setRegistroFormaPagoBancoOriginal((RegistroFormaPagoBanco)registroformapagobanco.clone());		
	}
	
	public static void setRegistroFormaPagoBancosOriginalStatic(List<RegistroFormaPagoBanco> registroformapagobancos)throws Exception  {
		
		for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos){
			registroformapagobanco.setRegistroFormaPagoBancoOriginal((RegistroFormaPagoBanco)registroformapagobanco.clone());
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
	
	public  RegistroFormaPagoBanco getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		
		
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
	
	public  RegistroFormaPagoBanco getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.RegistroFormaPagoBanco.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRegistroFormaPagoBancoOriginal(new RegistroFormaPagoBanco());
      	    	entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRegistroFormaPagoBanco("",entity,resultSet); 
				
				//entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRegistroFormaPagoBanco(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RegistroFormaPagoBanco getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();
				
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
	
	public  RegistroFormaPagoBanco getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.RegistroFormaPagoBanco.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRegistroFormaPagoBancoOriginal(new RegistroFormaPagoBanco());
      	    	entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRegistroFormaPagoBanco("",entity,resultSet);    
				
				//entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRegistroFormaPagoBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RegistroFormaPagoBanco
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.RegistroFormaPagoBanco.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRegistroFormaPagoBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RegistroFormaPagoBanco> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		
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
	
	public  List<RegistroFormaPagoBanco> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RegistroFormaPagoBanco();
      	    	entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRegistroFormaPagoBanco("",entity,resultSet);
      	    	
				//entity.setRegistroFormaPagoBancoOriginal( new RegistroFormaPagoBanco());
      	    	//entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRegistroFormaPagoBancos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RegistroFormaPagoBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
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
	
	public  List<RegistroFormaPagoBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RegistroFormaPagoBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapRegistroFormaPagoBanco();
					//entity.setMapRegistroFormaPagoBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRegistroFormaPagoBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRegistroFormaPagoBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
					entity=RegistroFormaPagoBancoDataAccess.getEntityRegistroFormaPagoBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRegistroFormaPagoBancoOriginal( new RegistroFormaPagoBanco());
					////entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRegistroFormaPagoBancos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RegistroFormaPagoBanco getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
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
	
	public  RegistroFormaPagoBanco getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RegistroFormaPagoBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapRegistroFormaPagoBanco();
					//entity.setMapRegistroFormaPagoBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRegistroFormaPagoBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRegistroFormaPagoBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
					entity=RegistroFormaPagoBancoDataAccess.getEntityRegistroFormaPagoBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRegistroFormaPagoBancoOriginal( new RegistroFormaPagoBanco());
					////entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRegistroFormaPagoBanco(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RegistroFormaPagoBanco getEntityRegistroFormaPagoBanco(String strPrefijo,RegistroFormaPagoBanco entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RegistroFormaPagoBanco.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RegistroFormaPagoBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RegistroFormaPagoBancoDataAccess.setFieldReflectionRegistroFormaPagoBanco(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRegistroFormaPagoBanco=RegistroFormaPagoBancoConstantesFunciones.getTodosTiposColumnasRegistroFormaPagoBanco();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRegistroFormaPagoBanco) {
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
							field = RegistroFormaPagoBanco.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RegistroFormaPagoBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RegistroFormaPagoBancoDataAccess.setFieldReflectionRegistroFormaPagoBanco(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRegistroFormaPagoBanco(Field field,String strPrefijo,String sColumn,RegistroFormaPagoBanco entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RegistroFormaPagoBancoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.VALORMONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RegistroFormaPagoBancoConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RegistroFormaPagoBanco>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RegistroFormaPagoBanco();
					entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRegistroFormaPagoBanco("",entity,resultSet);
					
					//entity.setRegistroFormaPagoBancoOriginal( new RegistroFormaPagoBanco());
					//entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
					//entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRegistroFormaPagoBancos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RegistroFormaPagoBanco>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RegistroFormaPagoBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
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
	
	public  List<RegistroFormaPagoBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RegistroFormaPagoBanco();
      	    	entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRegistroFormaPagoBanco("",entity,resultSet);
      	    	
				//entity.setRegistroFormaPagoBancoOriginal( new RegistroFormaPagoBanco());
      	    	//entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRegistroFormaPagoBancos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RegistroFormaPagoBanco> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
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
	
	public  List<RegistroFormaPagoBanco> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RegistroFormaPagoBanco> entities = new  ArrayList<RegistroFormaPagoBanco>();
		RegistroFormaPagoBanco entity = new RegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RegistroFormaPagoBanco();
      	    	entity=super.getEntity("",entity,resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRegistroFormaPagoBanco("",entity,resultSet);
      	    	
				//entity.setRegistroFormaPagoBancoOriginal( new RegistroFormaPagoBanco());
      	    	//entity.setRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getRegistroFormaPagoBancoOriginal(),resultSet,RegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRegistroFormaPagoBancoOriginal(this.getEntityRegistroFormaPagoBanco("",entity.getRegistroFormaPagoBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRegistroFormaPagoBancos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RegistroFormaPagoBanco getEntityRegistroFormaPagoBanco(String strPrefijo,RegistroFormaPagoBanco entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDPERIODO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_tipo_forma_pago(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO));
				entity.setid_estado_registro_forma_pago_banco(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE));
				entity.setnombre_banco(resultSet.getString(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO));
				entity.setnombre_girador(resultSet.getString(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setnumero_cuenta(resultSet.getString(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA));
				entity.setnumero_cheque(resultSet.getString(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE));
				entity.setvalor_monto(resultSet.getDouble(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.VALORMONTO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.FECHA).getTime()));
				entity.setfecha_vencimiento_original(new Date(resultSet.getDate(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL).getTime()));
				entity.setnumero_cambio(resultSet.getInt(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO));
				entity.setid_anio(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+RegistroFormaPagoBancoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRegistroFormaPagoBanco(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RegistroFormaPagoBanco entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RegistroFormaPagoBancoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RegistroFormaPagoBancoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RegistroFormaPagoBancoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RegistroFormaPagoBancoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RegistroFormaPagoBancoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RegistroFormaPagoBancoDataAccess.TABLENAME,RegistroFormaPagoBancoDataAccess.ISWITHSTOREPROCEDURES);
			
			RegistroFormaPagoBancoDataAccess.setRegistroFormaPagoBancoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relregistroformapagobanco.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relregistroformapagobanco.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relregistroformapagobanco.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relregistroformapagobanco.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relregistroformapagobanco.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public TipoFormaPago getTipoFormaPago(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		TipoFormaPago tipoformapago= new TipoFormaPago();

		try {
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,relregistroformapagobanco.getid_tipo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapago;

	}

	public EstadoRegistroFormaPagoBanco getEstadoRegistroFormaPagoBanco(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		EstadoRegistroFormaPagoBanco estadoregistroformapagobanco= new EstadoRegistroFormaPagoBanco();

		try {
			EstadoRegistroFormaPagoBancoDataAccess estadoregistroformapagobancoDataAccess=new EstadoRegistroFormaPagoBancoDataAccess();

			estadoregistroformapagobancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoregistroformapagobancoDataAccess.setConnexionType(this.connexionType);
			estadoregistroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);

			estadoregistroformapagobanco=estadoregistroformapagobancoDataAccess.getEntity(connexion,relregistroformapagobanco.getid_estado_registro_forma_pago_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoregistroformapagobanco;

	}

	public Cliente getCliente(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relregistroformapagobanco.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Anio getAnio(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relregistroformapagobanco.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,RegistroFormaPagoBanco relregistroformapagobanco)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relregistroformapagobanco.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RegistroFormaPagoBanco registroformapagobanco) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!registroformapagobanco.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(registroformapagobanco.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(registroformapagobanco.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(registroformapagobanco.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(registroformapagobanco.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(registroformapagobanco.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_forma_pago.setValue(registroformapagobanco.getid_tipo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_registro_forma_pago_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_registro_forma_pago_banco.setValue(registroformapagobanco.getid_estado_registro_forma_pago_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_registro_forma_pago_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(registroformapagobanco.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_banco=new ParameterValue<String>();
					parameterMaintenanceValuenombre_banco.setValue(registroformapagobanco.getnombre_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_girador=new ParameterValue<String>();
					parameterMaintenanceValuenombre_girador.setValue(registroformapagobanco.getnombre_girador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_girador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(registroformapagobanco.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta.setValue(registroformapagobanco.getnumero_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque.setValue(registroformapagobanco.getnumero_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_monto=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_monto.setValue(registroformapagobanco.getvalor_monto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_monto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(registroformapagobanco.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento_original=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento_original.setValue(registroformapagobanco.getfecha_vencimiento_original());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento_original);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cambio=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cambio.setValue(registroformapagobanco.getnumero_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(registroformapagobanco.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(registroformapagobanco.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!registroformapagobanco.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(registroformapagobanco.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(registroformapagobanco.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(registroformapagobanco.getId());
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
	
	public void setIsNewIsChangedFalseRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco)throws Exception  {		
		registroformapagobanco.setIsNew(false);
		registroformapagobanco.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> registroformapagobancos)throws Exception  {				
		for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos) {
			registroformapagobanco.setIsNew(false);
			registroformapagobanco.setIsChanged(false);
		}
	}
	
	public void generarExportarRegistroFormaPagoBanco(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
