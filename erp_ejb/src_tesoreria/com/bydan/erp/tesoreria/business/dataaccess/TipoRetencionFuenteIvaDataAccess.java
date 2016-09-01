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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//TipoRetencionFuenteIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoRetencionFuenteIvaDataAccess extends  TipoRetencionFuenteIvaDataAccessAdditional{ //TipoRetencionFuenteIvaDataAccessAdditional,DataAccessHelper<TipoRetencionFuenteIva>
	//static Logger logger = Logger.getLogger(TipoRetencionFuenteIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_retencion_fuente_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+"(id,version_row,id_pais,codigo,nombre,porcentaje,monto_minimo,id_cuenta_contable,id_cuenta_contable_credito,es_retencion_iva,es_debito,es_con_iva_factura,es_con_sub_total_factura,es_con_secuencial)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,codigo=?,nombre=?,porcentaje=?,monto_minimo=?,id_cuenta_contable=?,id_cuenta_contable_credito=?,es_retencion_iva=?,es_debito=?,es_con_iva_factura=?,es_con_sub_total_factura=?,es_con_secuencial=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporetencionfuenteiva from "+TipoRetencionFuenteIvaConstantesFunciones.SPERSISTENCENAME+" tiporetencionfuenteiva";
	public static String QUERYSELECTNATIVE="select "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id_pais,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".nombre,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".porcentaje,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".monto_minimo,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_retencion_iva,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_debito,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_con_iva_factura,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_con_sub_total_factura,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_con_secuencial from "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME;//+" as "+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".nombre from "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME;//+" as "+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,codigo=?,nombre=?,porcentaje=?,monto_minimo=?,id_cuenta_contable=?,id_cuenta_contable_credito=?,es_retencion_iva=?,es_debito=?,es_con_iva_factura=?,es_con_sub_total_factura=?,es_con_secuencial=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORETENCIONFUENTEIVA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORETENCIONFUENTEIVA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORETENCIONFUENTEIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORETENCIONFUENTEIVA_SELECT(?,?)";
	
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
	
	
	protected TipoRetencionFuenteIvaDataAccessAdditional tiporetencionfuenteivaDataAccessAdditional=null;
	
	public TipoRetencionFuenteIvaDataAccessAdditional getTipoRetencionFuenteIvaDataAccessAdditional() {
		return this.tiporetencionfuenteivaDataAccessAdditional;
	}
	
	public void setTipoRetencionFuenteIvaDataAccessAdditional(TipoRetencionFuenteIvaDataAccessAdditional tiporetencionfuenteivaDataAccessAdditional) {
		try {
			this.tiporetencionfuenteivaDataAccessAdditional=tiporetencionfuenteivaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoRetencionFuenteIvaDataAccess() {
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
		TipoRetencionFuenteIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRetencionFuenteIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRetencionFuenteIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRetencionFuenteIvaOriginal(TipoRetencionFuenteIva tiporetencionfuenteiva)throws Exception  {
		tiporetencionfuenteiva.setTipoRetencionFuenteIvaOriginal((TipoRetencionFuenteIva)tiporetencionfuenteiva.clone());		
	}
	
	public void setTipoRetencionFuenteIvasOriginal(List<TipoRetencionFuenteIva> tiporetencionfuenteivas)throws Exception  {
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas){
			tiporetencionfuenteiva.setTipoRetencionFuenteIvaOriginal((TipoRetencionFuenteIva)tiporetencionfuenteiva.clone());
		}
	}
	
	public static void setTipoRetencionFuenteIvaOriginalStatic(TipoRetencionFuenteIva tiporetencionfuenteiva)throws Exception  {
		tiporetencionfuenteiva.setTipoRetencionFuenteIvaOriginal((TipoRetencionFuenteIva)tiporetencionfuenteiva.clone());		
	}
	
	public static void setTipoRetencionFuenteIvasOriginalStatic(List<TipoRetencionFuenteIva> tiporetencionfuenteivas)throws Exception  {
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas){
			tiporetencionfuenteiva.setTipoRetencionFuenteIvaOriginal((TipoRetencionFuenteIva)tiporetencionfuenteiva.clone());
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
	
	public  TipoRetencionFuenteIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		
		
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
	
	public  TipoRetencionFuenteIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TipoRetencionFuenteIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRetencionFuenteIvaOriginal(new TipoRetencionFuenteIva());
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRetencionFuenteIva("",entity,resultSet); 
				
				//entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRetencionFuenteIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRetencionFuenteIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();
				
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
	
	public  TipoRetencionFuenteIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionFuenteIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoRetencionFuenteIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRetencionFuenteIvaOriginal(new TipoRetencionFuenteIva());
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRetencionFuenteIva("",entity,resultSet);    
				
				//entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRetencionFuenteIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRetencionFuenteIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionFuenteIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoRetencionFuenteIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRetencionFuenteIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRetencionFuenteIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		
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
	
	public  List<TipoRetencionFuenteIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionFuenteIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionFuenteIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencionFuenteIva("",entity,resultSet);
      	    	
				//entity.setTipoRetencionFuenteIvaOriginal( new TipoRetencionFuenteIva());
      	    	//entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencionFuenteIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionFuenteIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRetencionFuenteIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
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
	
	public  List<TipoRetencionFuenteIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionFuenteIva();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRetencionFuenteIva();
					//entity.setMapTipoRetencionFuenteIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRetencionFuenteIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRetencionFuenteIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         		
					entity=TipoRetencionFuenteIvaDataAccess.getEntityTipoRetencionFuenteIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRetencionFuenteIvaOriginal( new TipoRetencionFuenteIva());
					////entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencionFuenteIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionFuenteIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRetencionFuenteIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
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
	
	public  TipoRetencionFuenteIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionFuenteIva();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRetencionFuenteIva();
					//entity.setMapTipoRetencionFuenteIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRetencionFuenteIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRetencionFuenteIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         		
					entity=TipoRetencionFuenteIvaDataAccess.getEntityTipoRetencionFuenteIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRetencionFuenteIvaOriginal( new TipoRetencionFuenteIva());
					////entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRetencionFuenteIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionFuenteIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRetencionFuenteIva getEntityTipoRetencionFuenteIva(String strPrefijo,TipoRetencionFuenteIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRetencionFuenteIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRetencionFuenteIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRetencionFuenteIvaDataAccess.setFieldReflectionTipoRetencionFuenteIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRetencionFuenteIva=TipoRetencionFuenteIvaConstantesFunciones.getTodosTiposColumnasTipoRetencionFuenteIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRetencionFuenteIva) {
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
							field = TipoRetencionFuenteIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRetencionFuenteIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRetencionFuenteIvaDataAccess.setFieldReflectionTipoRetencionFuenteIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRetencionFuenteIva(Field field,String strPrefijo,String sColumn,TipoRetencionFuenteIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRetencionFuenteIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRetencionFuenteIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionFuenteIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRetencionFuenteIva();
					entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRetencionFuenteIva("",entity,resultSet);
					
					//entity.setTipoRetencionFuenteIvaOriginal( new TipoRetencionFuenteIva());
					//entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRetencionFuenteIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionFuenteIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRetencionFuenteIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionFuenteIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionFuenteIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRetencionFuenteIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
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
	
	public  List<TipoRetencionFuenteIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionFuenteIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencionFuenteIva("",entity,resultSet);
      	    	
				//entity.setTipoRetencionFuenteIvaOriginal( new TipoRetencionFuenteIva());
      	    	//entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRetencionFuenteIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionFuenteIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRetencionFuenteIva> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
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
	
	public  List<TipoRetencionFuenteIva> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionFuenteIva> entities = new  ArrayList<TipoRetencionFuenteIva>();
		TipoRetencionFuenteIva entity = new TipoRetencionFuenteIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionFuenteIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencionFuenteIva("",entity,resultSet);
      	    	
				//entity.setTipoRetencionFuenteIvaOriginal( new TipoRetencionFuenteIva());
      	    	//entity.setTipoRetencionFuenteIvaOriginal(super.getEntity("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet,TipoRetencionFuenteIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionFuenteIvaOriginal(this.getEntityTipoRetencionFuenteIva("",entity.getTipoRetencionFuenteIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencionFuenteIvas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoRetencionFuenteIva getEntityTipoRetencionFuenteIva(String strPrefijo,TipoRetencionFuenteIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.IDPAIS));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.NOMBRE));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE));
				entity.setmonto_minimo(resultSet.getDouble(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setes_retencion_iva(resultSet.getBoolean(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA));
				entity.setes_debito(resultSet.getBoolean(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO));
				entity.setes_con_iva_factura(resultSet.getBoolean(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA));
				entity.setes_con_sub_total_factura(resultSet.getBoolean(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA));
				entity.setes_con_secuencial(resultSet.getBoolean(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+TipoRetencionFuenteIvaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRetencionFuenteIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRetencionFuenteIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRetencionFuenteIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRetencionFuenteIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRetencionFuenteIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRetencionFuenteIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRetencionFuenteIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRetencionFuenteIvaDataAccess.TABLENAME,TipoRetencionFuenteIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRetencionFuenteIvaDataAccess.setTipoRetencionFuenteIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoRetencionFuenteIva reltiporetencionfuenteiva)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltiporetencionfuenteiva.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public CuentaContable getCuentaContable(Connexion connexion,TipoRetencionFuenteIva reltiporetencionfuenteiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltiporetencionfuenteiva.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,TipoRetencionFuenteIva reltiporetencionfuenteiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltiporetencionfuenteiva.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporetencionfuenteiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiporetencionfuenteiva.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tiporetencionfuenteiva.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiporetencionfuenteiva.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporetencionfuenteiva.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(tiporetencionfuenteiva.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_minimo=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_minimo.setValue(tiporetencionfuenteiva.getmonto_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(tiporetencionfuenteiva.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(tiporetencionfuenteiva.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_retencion_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_retencion_iva.setValue(tiporetencionfuenteiva.getes_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_debito=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_debito.setValue(tiporetencionfuenteiva.getes_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_con_iva_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_con_iva_factura.setValue(tiporetencionfuenteiva.getes_con_iva_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_con_iva_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_con_sub_total_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_con_sub_total_factura.setValue(tiporetencionfuenteiva.getes_con_sub_total_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_con_sub_total_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_con_secuencial=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_con_secuencial.setValue(tiporetencionfuenteiva.getes_con_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_con_secuencial);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporetencionfuenteiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporetencionfuenteiva.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporetencionfuenteiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporetencionfuenteiva.getId());
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
	
	public void setIsNewIsChangedFalseTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteiva)throws Exception  {		
		tiporetencionfuenteiva.setIsNew(false);
		tiporetencionfuenteiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRetencionFuenteIvas(List<TipoRetencionFuenteIva> tiporetencionfuenteivas)throws Exception  {				
		for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas) {
			tiporetencionfuenteiva.setIsNew(false);
			tiporetencionfuenteiva.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRetencionFuenteIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
