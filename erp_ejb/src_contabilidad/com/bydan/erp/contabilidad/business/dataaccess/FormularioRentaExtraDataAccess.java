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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//FormularioRentaExtraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class FormularioRentaExtraDataAccess extends  FormularioRentaExtraDataAccessAdditional{ //FormularioRentaExtraDataAccessAdditional,DataAccessHelper<FormularioRentaExtra>
	//static Logger logger = Logger.getLogger(FormularioRentaExtraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formulario_renta_extra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_ejercicio,id_periodo,id_dato_formulario_renta,id_forma_pago,id_banco,pago_previo,interes_mora,valor_multa,forma_pago1,forma_pago2,numero_nota_credito1,numero_nota_credito2,numero_nota_credito3,numero_nota_credito4,valor_nota_credito1,valor_nota_credito2,valor_nota_credito3,valor_nota_credito4,numero_comprobante1,numero_comprobante2,valor_comprobante1,valor_comprobante2,valor301,valor303,valor305,valor307,valor351,valor355,valor357,valor359,valor361)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_dato_formulario_renta=?,id_forma_pago=?,id_banco=?,pago_previo=?,interes_mora=?,valor_multa=?,forma_pago1=?,forma_pago2=?,numero_nota_credito1=?,numero_nota_credito2=?,numero_nota_credito3=?,numero_nota_credito4=?,valor_nota_credito1=?,valor_nota_credito2=?,valor_nota_credito3=?,valor_nota_credito4=?,numero_comprobante1=?,numero_comprobante2=?,valor_comprobante1=?,valor_comprobante2=?,valor301=?,valor303=?,valor305=?,valor307=?,valor351=?,valor355=?,valor357=?,valor359=?,valor361=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formulariorentaextra from "+FormularioRentaExtraConstantesFunciones.SPERSISTENCENAME+" formulariorentaextra";
	public static String QUERYSELECTNATIVE="select "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".version_row,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_empresa,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_periodo,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_dato_formulario_renta,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_forma_pago,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_banco,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".pago_previo,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".interes_mora,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_multa,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".forma_pago1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".forma_pago2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito3,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito4,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito3,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito4,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_comprobante1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_comprobante2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_comprobante1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_comprobante2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor301,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor303,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor305,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor307,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor351,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor355,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor357,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor359,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor361 from "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME;//+" as "+FormularioRentaExtraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".version_row from "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME;//+" as "+FormularioRentaExtraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_dato_formulario_renta=?,id_forma_pago=?,id_banco=?,pago_previo=?,interes_mora=?,valor_multa=?,forma_pago1=?,forma_pago2=?,numero_nota_credito1=?,numero_nota_credito2=?,numero_nota_credito3=?,numero_nota_credito4=?,valor_nota_credito1=?,valor_nota_credito2=?,valor_nota_credito3=?,valor_nota_credito4=?,numero_comprobante1=?,numero_comprobante2=?,valor_comprobante1=?,valor_comprobante2=?,valor301=?,valor303=?,valor305=?,valor307=?,valor351=?,valor355=?,valor357=?,valor359=?,valor361=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMULARIORENTAEXTRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMULARIORENTAEXTRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMULARIORENTAEXTRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMULARIORENTAEXTRA_SELECT(?,?)";
	
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
	
	
	protected FormularioRentaExtraDataAccessAdditional formulariorentaextraDataAccessAdditional=null;
	
	public FormularioRentaExtraDataAccessAdditional getFormularioRentaExtraDataAccessAdditional() {
		return this.formulariorentaextraDataAccessAdditional;
	}
	
	public void setFormularioRentaExtraDataAccessAdditional(FormularioRentaExtraDataAccessAdditional formulariorentaextraDataAccessAdditional) {
		try {
			this.formulariorentaextraDataAccessAdditional=formulariorentaextraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormularioRentaExtraDataAccess() {
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
		FormularioRentaExtraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormularioRentaExtraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormularioRentaExtraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormularioRentaExtraOriginal(FormularioRentaExtra formulariorentaextra)throws Exception  {
		formulariorentaextra.setFormularioRentaExtraOriginal((FormularioRentaExtra)formulariorentaextra.clone());		
	}
	
	public void setFormularioRentaExtrasOriginal(List<FormularioRentaExtra> formulariorentaextras)throws Exception  {
		
		for(FormularioRentaExtra formulariorentaextra:formulariorentaextras){
			formulariorentaextra.setFormularioRentaExtraOriginal((FormularioRentaExtra)formulariorentaextra.clone());
		}
	}
	
	public static void setFormularioRentaExtraOriginalStatic(FormularioRentaExtra formulariorentaextra)throws Exception  {
		formulariorentaextra.setFormularioRentaExtraOriginal((FormularioRentaExtra)formulariorentaextra.clone());		
	}
	
	public static void setFormularioRentaExtrasOriginalStatic(List<FormularioRentaExtra> formulariorentaextras)throws Exception  {
		
		for(FormularioRentaExtra formulariorentaextra:formulariorentaextras){
			formulariorentaextra.setFormularioRentaExtraOriginal((FormularioRentaExtra)formulariorentaextra.clone());
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
	
	public  FormularioRentaExtra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioRentaExtra entity = new FormularioRentaExtra();		
		
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
	
	public  FormularioRentaExtra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioRentaExtra entity = new FormularioRentaExtra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.FormularioRentaExtra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormularioRentaExtraOriginal(new FormularioRentaExtra());
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioRentaExtra("",entity,resultSet); 
				
				//entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioRentaExtra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormularioRentaExtra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioRentaExtra entity = new FormularioRentaExtra();
				
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
	
	public  FormularioRentaExtra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioRentaExtra entity = new FormularioRentaExtra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FormularioRentaExtra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormularioRentaExtraOriginal(new FormularioRentaExtra());
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioRentaExtra("",entity,resultSet);    
				
				//entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioRentaExtra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormularioRentaExtra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormularioRentaExtra entity = new FormularioRentaExtra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FormularioRentaExtra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormularioRentaExtra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormularioRentaExtra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		
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
	
	public  List<FormularioRentaExtra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRentaExtra();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRentaExtra("",entity,resultSet);
      	    	
				//entity.setFormularioRentaExtraOriginal( new FormularioRentaExtra());
      	    	//entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRentaExtras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRentaExtra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioRentaExtra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
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
	
	public  List<FormularioRentaExtra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRentaExtra();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioRentaExtra();
					//entity.setMapFormularioRentaExtra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormularioRentaExtraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioRentaExtra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         		
					entity=FormularioRentaExtraDataAccess.getEntityFormularioRentaExtra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioRentaExtraOriginal( new FormularioRentaExtra());
					////entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRentaExtras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRentaExtra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormularioRentaExtra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
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
	
	public  FormularioRentaExtra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRentaExtra();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioRentaExtra();
					//entity.setMapFormularioRentaExtra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormularioRentaExtraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioRentaExtra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         		
					entity=FormularioRentaExtraDataAccess.getEntityFormularioRentaExtra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioRentaExtraOriginal( new FormularioRentaExtra());
					////entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormularioRentaExtra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRentaExtra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormularioRentaExtra getEntityFormularioRentaExtra(String strPrefijo,FormularioRentaExtra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormularioRentaExtra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormularioRentaExtra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormularioRentaExtraDataAccess.setFieldReflectionFormularioRentaExtra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormularioRentaExtra=FormularioRentaExtraConstantesFunciones.getTodosTiposColumnasFormularioRentaExtra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormularioRentaExtra) {
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
							field = FormularioRentaExtra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormularioRentaExtra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormularioRentaExtraDataAccess.setFieldReflectionFormularioRentaExtra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormularioRentaExtra(Field field,String strPrefijo,String sColumn,FormularioRentaExtra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormularioRentaExtraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.IDFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.PAGOPREVIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.INTERESMORA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORMULTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.FORMAPAGO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.FORMAPAGO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR301:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR303:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR305:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR307:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR351:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR355:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR357:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR359:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaExtraConstantesFunciones.VALOR361:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioRentaExtra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FormularioRentaExtra();
					entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormularioRentaExtra("",entity,resultSet);
					
					//entity.setFormularioRentaExtraOriginal( new FormularioRentaExtra());
					//entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
					//entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormularioRentaExtras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRentaExtra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioRentaExtra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRentaExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FormularioRentaExtra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
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
	
	public  List<FormularioRentaExtra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRentaExtra();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRentaExtra("",entity,resultSet);
      	    	
				//entity.setFormularioRentaExtraOriginal( new FormularioRentaExtra());
      	    	//entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormularioRentaExtras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRentaExtra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioRentaExtra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
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
	
	public  List<FormularioRentaExtra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRentaExtra> entities = new  ArrayList<FormularioRentaExtra>();
		FormularioRentaExtra entity = new FormularioRentaExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRentaExtra();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRentaExtra("",entity,resultSet);
      	    	
				//entity.setFormularioRentaExtraOriginal( new FormularioRentaExtra());
      	    	//entity.setFormularioRentaExtraOriginal(super.getEntity("",entity.getFormularioRentaExtraOriginal(),resultSet,FormularioRentaExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaExtraOriginal(this.getEntityFormularioRentaExtra("",entity.getFormularioRentaExtraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRentaExtras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormularioRentaExtra getEntityFormularioRentaExtra(String strPrefijo,FormularioRentaExtra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormularioRentaExtraConstantesFunciones.IDEMPRESA));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FormularioRentaExtraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FormularioRentaExtraConstantesFunciones.IDPERIODO));
				entity.setid_dato_formulario_renta(resultSet.getLong(strPrefijo+FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA));
				entity.setid_forma_pago(resultSet.getLong(strPrefijo+FormularioRentaExtraConstantesFunciones.IDFORMAPAGO));
				entity.setid_banco(resultSet.getLong(strPrefijo+FormularioRentaExtraConstantesFunciones.IDBANCO));
				entity.setpago_previo(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.PAGOPREVIO));
				entity.setinteres_mora(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.INTERESMORA));
				entity.setvalor_multa(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORMULTA));
				entity.setforma_pago1(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.FORMAPAGO1));
				entity.setforma_pago2(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.FORMAPAGO2));
				entity.setnumero_nota_credito1(resultSet.getString(strPrefijo+FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1));
				entity.setnumero_nota_credito2(resultSet.getString(strPrefijo+FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2));
				entity.setnumero_nota_credito3(resultSet.getString(strPrefijo+FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3));
				entity.setnumero_nota_credito4(resultSet.getString(strPrefijo+FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4));
				entity.setvalor_nota_credito1(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1));
				entity.setvalor_nota_credito2(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2));
				entity.setvalor_nota_credito3(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3));
				entity.setvalor_nota_credito4(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4));
				entity.setnumero_comprobante1(resultSet.getString(strPrefijo+FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1));
				entity.setnumero_comprobante2(resultSet.getString(strPrefijo+FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2));
				entity.setvalor_comprobante1(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1));
				entity.setvalor_comprobante2(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2));
				entity.setvalor301(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR301));
				entity.setvalor303(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR303));
				entity.setvalor305(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR305));
				entity.setvalor307(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR307));
				entity.setvalor351(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR351));
				entity.setvalor355(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR355));
				entity.setvalor357(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR357));
				entity.setvalor359(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR359));
				entity.setvalor361(resultSet.getDouble(strPrefijo+FormularioRentaExtraConstantesFunciones.VALOR361));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormularioRentaExtra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormularioRentaExtra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormularioRentaExtraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormularioRentaExtraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormularioRentaExtraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormularioRentaExtraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormularioRentaExtraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormularioRentaExtraDataAccess.TABLENAME,FormularioRentaExtraDataAccess.ISWITHSTOREPROCEDURES);
			
			FormularioRentaExtraDataAccess.setFormularioRentaExtraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormularioRentaExtra relformulariorentaextra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformulariorentaextra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,FormularioRentaExtra relformulariorentaextra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relformulariorentaextra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,FormularioRentaExtra relformulariorentaextra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relformulariorentaextra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public DatoFormularioRenta getDatoFormularioRenta(Connexion connexion,FormularioRentaExtra relformulariorentaextra)throws SQLException,Exception {

		DatoFormularioRenta datoformulariorenta= new DatoFormularioRenta();

		try {
			DatoFormularioRentaDataAccess datoformulariorentaDataAccess=new DatoFormularioRentaDataAccess();

			datoformulariorentaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			datoformulariorentaDataAccess.setConnexionType(this.connexionType);
			datoformulariorentaDataAccess.setParameterDbType(this.parameterDbType);

			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion,relformulariorentaextra.getid_dato_formulario_renta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datoformulariorenta;

	}

	public FormaPago getFormaPago(Connexion connexion,FormularioRentaExtra relformulariorentaextra)throws SQLException,Exception {

		FormaPago formapago= new FormaPago();

		try {
			FormaPagoDataAccess formapagoDataAccess=new FormaPagoDataAccess();

			formapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formapagoDataAccess.setConnexionType(this.connexionType);
			formapagoDataAccess.setParameterDbType(this.parameterDbType);

			formapago=formapagoDataAccess.getEntity(connexion,relformulariorentaextra.getid_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapago;

	}

	public Banco getBanco(Connexion connexion,FormularioRentaExtra relformulariorentaextra)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relformulariorentaextra.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormularioRentaExtra formulariorentaextra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formulariorentaextra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formulariorentaextra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(formulariorentaextra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(formulariorentaextra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dato_formulario_renta=new ParameterValue<Long>();
					parameterMaintenanceValueid_dato_formulario_renta.setValue(formulariorentaextra.getid_dato_formulario_renta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dato_formulario_renta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_forma_pago.setValue(formulariorentaextra.getid_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(formulariorentaextra.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepago_previo=new ParameterValue<Double>();
					parameterMaintenanceValuepago_previo.setValue(formulariorentaextra.getpago_previo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepago_previo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinteres_mora=new ParameterValue<Double>();
					parameterMaintenanceValueinteres_mora.setValue(formulariorentaextra.getinteres_mora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinteres_mora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_multa=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_multa.setValue(formulariorentaextra.getvalor_multa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_multa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueforma_pago1=new ParameterValue<Double>();
					parameterMaintenanceValueforma_pago1.setValue(formulariorentaextra.getforma_pago1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueforma_pago1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueforma_pago2=new ParameterValue<Double>();
					parameterMaintenanceValueforma_pago2.setValue(formulariorentaextra.getforma_pago2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueforma_pago2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_nota_credito1=new ParameterValue<String>();
					parameterMaintenanceValuenumero_nota_credito1.setValue(formulariorentaextra.getnumero_nota_credito1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_nota_credito1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_nota_credito2=new ParameterValue<String>();
					parameterMaintenanceValuenumero_nota_credito2.setValue(formulariorentaextra.getnumero_nota_credito2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_nota_credito2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_nota_credito3=new ParameterValue<String>();
					parameterMaintenanceValuenumero_nota_credito3.setValue(formulariorentaextra.getnumero_nota_credito3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_nota_credito3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_nota_credito4=new ParameterValue<String>();
					parameterMaintenanceValuenumero_nota_credito4.setValue(formulariorentaextra.getnumero_nota_credito4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_nota_credito4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_nota_credito1=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_nota_credito1.setValue(formulariorentaextra.getvalor_nota_credito1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_nota_credito1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_nota_credito2=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_nota_credito2.setValue(formulariorentaextra.getvalor_nota_credito2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_nota_credito2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_nota_credito3=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_nota_credito3.setValue(formulariorentaextra.getvalor_nota_credito3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_nota_credito3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_nota_credito4=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_nota_credito4.setValue(formulariorentaextra.getvalor_nota_credito4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_nota_credito4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante1=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante1.setValue(formulariorentaextra.getnumero_comprobante1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante2=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante2.setValue(formulariorentaextra.getnumero_comprobante2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_comprobante1=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_comprobante1.setValue(formulariorentaextra.getvalor_comprobante1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_comprobante1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_comprobante2=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_comprobante2.setValue(formulariorentaextra.getvalor_comprobante2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_comprobante2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor301=new ParameterValue<Double>();
					parameterMaintenanceValuevalor301.setValue(formulariorentaextra.getvalor301());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor301);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor303=new ParameterValue<Double>();
					parameterMaintenanceValuevalor303.setValue(formulariorentaextra.getvalor303());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor303);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor305=new ParameterValue<Double>();
					parameterMaintenanceValuevalor305.setValue(formulariorentaextra.getvalor305());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor305);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor307=new ParameterValue<Double>();
					parameterMaintenanceValuevalor307.setValue(formulariorentaextra.getvalor307());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor307);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor351=new ParameterValue<Double>();
					parameterMaintenanceValuevalor351.setValue(formulariorentaextra.getvalor351());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor351);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor355=new ParameterValue<Double>();
					parameterMaintenanceValuevalor355.setValue(formulariorentaextra.getvalor355());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor355);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor357=new ParameterValue<Double>();
					parameterMaintenanceValuevalor357.setValue(formulariorentaextra.getvalor357());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor357);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor359=new ParameterValue<Double>();
					parameterMaintenanceValuevalor359.setValue(formulariorentaextra.getvalor359());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor359);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor361=new ParameterValue<Double>();
					parameterMaintenanceValuevalor361.setValue(formulariorentaextra.getvalor361());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor361);
					parametersTemp.add(parameterMaintenance);
					
						if(!formulariorentaextra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formulariorentaextra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formulariorentaextra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formulariorentaextra.getId());
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
	
	public void setIsNewIsChangedFalseFormularioRentaExtra(FormularioRentaExtra formulariorentaextra)throws Exception  {		
		formulariorentaextra.setIsNew(false);
		formulariorentaextra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormularioRentaExtras(List<FormularioRentaExtra> formulariorentaextras)throws Exception  {				
		for(FormularioRentaExtra formulariorentaextra:formulariorentaextras) {
			formulariorentaextra.setIsNew(false);
			formulariorentaextra.setIsChanged(false);
		}
	}
	
	public void generarExportarFormularioRentaExtra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
