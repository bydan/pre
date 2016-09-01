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
import com.bydan.erp.cartera.util.*;//BalanceGeneralClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class BalanceGeneralClienteDataAccess extends  BalanceGeneralClienteDataAccessAdditional{ //BalanceGeneralClienteDataAccessAdditional,DataAccessHelper<BalanceGeneralCliente>
	//static Logger logger = Logger.getLogger(BalanceGeneralClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="balance_general_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,caja_bancos_disponible,cuentas_por_cobrar_clientes,inventario,otros_activos_corrientes,total_activos_corrientes,bienes_inmuebles,bienes_muebles,otros_activos_no_corrientes,total_activos_no_corrientes,ventas_mensuales,costo_ventas_mensuales,utilidad_bruta,gastos_operativos,sueldos,servicios,arriendos,impuestos,utilidad_operativa,gastos_familiares,excedente_antes_dividendos,dividendos_bancos_otros,exedente_neto_mensual,deudas_bancarias,cuentas_por_pagar,anticipos_recibos,otras_cuentas_por_pagar,otras_deudas_familiares,total_pasivo_corriente,deudas_bancarias_largo_plazo,otros_pasivos_largo_plazo,total_pasivo_no_corriente,total_pasivo,patrimonio,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,caja_bancos_disponible=?,cuentas_por_cobrar_clientes=?,inventario=?,otros_activos_corrientes=?,total_activos_corrientes=?,bienes_inmuebles=?,bienes_muebles=?,otros_activos_no_corrientes=?,total_activos_no_corrientes=?,ventas_mensuales=?,costo_ventas_mensuales=?,utilidad_bruta=?,gastos_operativos=?,sueldos=?,servicios=?,arriendos=?,impuestos=?,utilidad_operativa=?,gastos_familiares=?,excedente_antes_dividendos=?,dividendos_bancos_otros=?,exedente_neto_mensual=?,deudas_bancarias=?,cuentas_por_pagar=?,anticipos_recibos=?,otras_cuentas_por_pagar=?,otras_deudas_familiares=?,total_pasivo_corriente=?,deudas_bancarias_largo_plazo=?,otros_pasivos_largo_plazo=?,total_pasivo_no_corriente=?,total_pasivo=?,patrimonio=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select balancegeneralcliente from "+BalanceGeneralClienteConstantesFunciones.SPERSISTENCENAME+" balancegeneralcliente";
	public static String QUERYSELECTNATIVE="select "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".version_row,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id_empresa,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id_cliente,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".caja_bancos_disponible,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".cuentas_por_cobrar_clientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".inventario,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otros_activos_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_activos_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".bienes_inmuebles,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".bienes_muebles,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otros_activos_no_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_activos_no_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".ventas_mensuales,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".costo_ventas_mensuales,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".utilidad_bruta,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".gastos_operativos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".sueldos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".servicios,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".arriendos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".impuestos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".utilidad_operativa,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".gastos_familiares,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".excedente_antes_dividendos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".dividendos_bancos_otros,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".exedente_neto_mensual,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".deudas_bancarias,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".cuentas_por_pagar,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".anticipos_recibos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otras_cuentas_por_pagar,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otras_deudas_familiares,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_pasivo_corriente,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".deudas_bancarias_largo_plazo,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otros_pasivos_largo_plazo,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_pasivo_no_corriente,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_pasivo,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".patrimonio,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".descripcion from "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME;//+" as "+BalanceGeneralClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".version_row from "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME;//+" as "+BalanceGeneralClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,caja_bancos_disponible=?,cuentas_por_cobrar_clientes=?,inventario=?,otros_activos_corrientes=?,total_activos_corrientes=?,bienes_inmuebles=?,bienes_muebles=?,otros_activos_no_corrientes=?,total_activos_no_corrientes=?,ventas_mensuales=?,costo_ventas_mensuales=?,utilidad_bruta=?,gastos_operativos=?,sueldos=?,servicios=?,arriendos=?,impuestos=?,utilidad_operativa=?,gastos_familiares=?,excedente_antes_dividendos=?,dividendos_bancos_otros=?,exedente_neto_mensual=?,deudas_bancarias=?,cuentas_por_pagar=?,anticipos_recibos=?,otras_cuentas_por_pagar=?,otras_deudas_familiares=?,total_pasivo_corriente=?,deudas_bancarias_largo_plazo=?,otros_pasivos_largo_plazo=?,total_pasivo_no_corriente=?,total_pasivo=?,patrimonio=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_BALANCEGENERALCLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_BALANCEGENERALCLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_BALANCEGENERALCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_BALANCEGENERALCLIENTE_SELECT(?,?)";
	
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
	
	
	protected BalanceGeneralClienteDataAccessAdditional balancegeneralclienteDataAccessAdditional=null;
	
	public BalanceGeneralClienteDataAccessAdditional getBalanceGeneralClienteDataAccessAdditional() {
		return this.balancegeneralclienteDataAccessAdditional;
	}
	
	public void setBalanceGeneralClienteDataAccessAdditional(BalanceGeneralClienteDataAccessAdditional balancegeneralclienteDataAccessAdditional) {
		try {
			this.balancegeneralclienteDataAccessAdditional=balancegeneralclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public BalanceGeneralClienteDataAccess() {
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
		BalanceGeneralClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		BalanceGeneralClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		BalanceGeneralClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setBalanceGeneralClienteOriginal(BalanceGeneralCliente balancegeneralcliente)throws Exception  {
		balancegeneralcliente.setBalanceGeneralClienteOriginal((BalanceGeneralCliente)balancegeneralcliente.clone());		
	}
	
	public void setBalanceGeneralClientesOriginal(List<BalanceGeneralCliente> balancegeneralclientes)throws Exception  {
		
		for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes){
			balancegeneralcliente.setBalanceGeneralClienteOriginal((BalanceGeneralCliente)balancegeneralcliente.clone());
		}
	}
	
	public static void setBalanceGeneralClienteOriginalStatic(BalanceGeneralCliente balancegeneralcliente)throws Exception  {
		balancegeneralcliente.setBalanceGeneralClienteOriginal((BalanceGeneralCliente)balancegeneralcliente.clone());		
	}
	
	public static void setBalanceGeneralClientesOriginalStatic(List<BalanceGeneralCliente> balancegeneralclientes)throws Exception  {
		
		for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes){
			balancegeneralcliente.setBalanceGeneralClienteOriginal((BalanceGeneralCliente)balancegeneralcliente.clone());
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
	
	public  BalanceGeneralCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		
		
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
	
	public  BalanceGeneralCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.BalanceGeneralCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setBalanceGeneralClienteOriginal(new BalanceGeneralCliente());
      	    	entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBalanceGeneralCliente("",entity,resultSet); 
				
				//entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseBalanceGeneralCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  BalanceGeneralCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BalanceGeneralCliente entity = new BalanceGeneralCliente();
				
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
	
	public  BalanceGeneralCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BalanceGeneralCliente entity = new BalanceGeneralCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BalanceGeneralClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.BalanceGeneralCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setBalanceGeneralClienteOriginal(new BalanceGeneralCliente());
      	    	entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBalanceGeneralCliente("",entity,resultSet);    
				
				//entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseBalanceGeneralCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //BalanceGeneralCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		BalanceGeneralCliente entity = new BalanceGeneralCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BalanceGeneralClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.BalanceGeneralCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseBalanceGeneralCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<BalanceGeneralCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		
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
	
	public  List<BalanceGeneralCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BalanceGeneralClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BalanceGeneralCliente();
      	    	entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBalanceGeneralCliente("",entity,resultSet);
      	    	
				//entity.setBalanceGeneralClienteOriginal( new BalanceGeneralCliente());
      	    	//entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBalanceGeneralClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBalanceGeneralCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BalanceGeneralCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
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
	
	public  List<BalanceGeneralCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BalanceGeneralCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapBalanceGeneralCliente();
					//entity.setMapBalanceGeneralCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapBalanceGeneralClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBalanceGeneralCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         		
					entity=BalanceGeneralClienteDataAccess.getEntityBalanceGeneralCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBalanceGeneralClienteOriginal( new BalanceGeneralCliente());
					////entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBalanceGeneralClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBalanceGeneralCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public BalanceGeneralCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
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
	
	public  BalanceGeneralCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BalanceGeneralCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapBalanceGeneralCliente();
					//entity.setMapBalanceGeneralCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapBalanceGeneralClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBalanceGeneralCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         		
					entity=BalanceGeneralClienteDataAccess.getEntityBalanceGeneralCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBalanceGeneralClienteOriginal( new BalanceGeneralCliente());
					////entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseBalanceGeneralCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBalanceGeneralCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static BalanceGeneralCliente getEntityBalanceGeneralCliente(String strPrefijo,BalanceGeneralCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = BalanceGeneralCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = BalanceGeneralCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					BalanceGeneralClienteDataAccess.setFieldReflectionBalanceGeneralCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasBalanceGeneralCliente=BalanceGeneralClienteConstantesFunciones.getTodosTiposColumnasBalanceGeneralCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasBalanceGeneralCliente) {
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
							field = BalanceGeneralCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = BalanceGeneralCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						BalanceGeneralClienteDataAccess.setFieldReflectionBalanceGeneralCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBalanceGeneralCliente(Field field,String strPrefijo,String sColumn,BalanceGeneralCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BalanceGeneralClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.INVENTARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.SUELDOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.SERVICIOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.ARRIENDOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.IMPUESTOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.TOTALPASIVO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.PATRIMONIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BalanceGeneralClienteConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BalanceGeneralCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BalanceGeneralClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new BalanceGeneralCliente();
					entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityBalanceGeneralCliente("",entity,resultSet);
					
					//entity.setBalanceGeneralClienteOriginal( new BalanceGeneralCliente());
					//entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseBalanceGeneralClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBalanceGeneralCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BalanceGeneralCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BalanceGeneralClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BalanceGeneralClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<BalanceGeneralCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
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
	
	public  List<BalanceGeneralCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BalanceGeneralCliente();
      	    	entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBalanceGeneralCliente("",entity,resultSet);
      	    	
				//entity.setBalanceGeneralClienteOriginal( new BalanceGeneralCliente());
      	    	//entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseBalanceGeneralClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBalanceGeneralCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BalanceGeneralCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
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
	
	public  List<BalanceGeneralCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BalanceGeneralCliente> entities = new  ArrayList<BalanceGeneralCliente>();
		BalanceGeneralCliente entity = new BalanceGeneralCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BalanceGeneralCliente();
      	    	entity=super.getEntity("",entity,resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBalanceGeneralCliente("",entity,resultSet);
      	    	
				//entity.setBalanceGeneralClienteOriginal( new BalanceGeneralCliente());
      	    	//entity.setBalanceGeneralClienteOriginal(super.getEntity("",entity.getBalanceGeneralClienteOriginal(),resultSet,BalanceGeneralClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBalanceGeneralClienteOriginal(this.getEntityBalanceGeneralCliente("",entity.getBalanceGeneralClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBalanceGeneralClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public BalanceGeneralCliente getEntityBalanceGeneralCliente(String strPrefijo,BalanceGeneralCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+BalanceGeneralClienteConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+BalanceGeneralClienteConstantesFunciones.IDCLIENTE));
				entity.setcaja_bancos_disponible(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE));
				entity.setcuentas_por_cobrar_clientes(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES));
				entity.setinventario(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.INVENTARIO));
				entity.setotros_activos_corrientes(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES));
				entity.settotal_activos_corrientes(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES));
				entity.setbienes_inmuebles(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES));
				entity.setbienes_muebles(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES));
				entity.setotros_activos_no_corrientes(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES));
				entity.settotal_activos_no_corrientes(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES));
				entity.setventas_mensuales(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES));
				entity.setcosto_ventas_mensuales(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES));
				entity.setutilidad_bruta(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA));
				entity.setgastos_operativos(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS));
				entity.setsueldos(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.SUELDOS));
				entity.setservicios(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.SERVICIOS));
				entity.setarriendos(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.ARRIENDOS));
				entity.setimpuestos(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.IMPUESTOS));
				entity.setutilidad_operativa(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA));
				entity.setgastos_familiares(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES));
				entity.setexcedente_antes_dividendos(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS));
				entity.setdividendos_bancos_otros(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS));
				entity.setexedente_neto_mensual(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL));
				entity.setdeudas_bancarias(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS));
				entity.setcuentas_por_pagar(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR));
				entity.setanticipos_recibos(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS));
				entity.setotras_cuentas_por_pagar(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR));
				entity.setotras_deudas_familiares(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES));
				entity.settotal_pasivo_corriente(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE));
				entity.setdeudas_bancarias_largo_plazo(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO));
				entity.setotros_pasivos_largo_plazo(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO));
				entity.settotal_pasivo_no_corriente(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE));
				entity.settotal_pasivo(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.TOTALPASIVO));
				entity.setpatrimonio(resultSet.getDouble(strPrefijo+BalanceGeneralClienteConstantesFunciones.PATRIMONIO));
				entity.setdescripcion(resultSet.getString(strPrefijo+BalanceGeneralClienteConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowBalanceGeneralCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(BalanceGeneralCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=BalanceGeneralClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=BalanceGeneralClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=BalanceGeneralClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=BalanceGeneralClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(BalanceGeneralClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,BalanceGeneralClienteDataAccess.TABLENAME,BalanceGeneralClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			BalanceGeneralClienteDataAccess.setBalanceGeneralClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,BalanceGeneralCliente relbalancegeneralcliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relbalancegeneralcliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,BalanceGeneralCliente relbalancegeneralcliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relbalancegeneralcliente.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,BalanceGeneralCliente balancegeneralcliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!balancegeneralcliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(balancegeneralcliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(balancegeneralcliente.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecaja_bancos_disponible=new ParameterValue<Double>();
					parameterMaintenanceValuecaja_bancos_disponible.setValue(balancegeneralcliente.getcaja_bancos_disponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecaja_bancos_disponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecuentas_por_cobrar_clientes=new ParameterValue<Double>();
					parameterMaintenanceValuecuentas_por_cobrar_clientes.setValue(balancegeneralcliente.getcuentas_por_cobrar_clientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecuentas_por_cobrar_clientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinventario=new ParameterValue<Double>();
					parameterMaintenanceValueinventario.setValue(balancegeneralcliente.getinventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_activos_corrientes=new ParameterValue<Double>();
					parameterMaintenanceValueotros_activos_corrientes.setValue(balancegeneralcliente.getotros_activos_corrientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_activos_corrientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_activos_corrientes=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_activos_corrientes.setValue(balancegeneralcliente.gettotal_activos_corrientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_activos_corrientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_inmuebles=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_inmuebles.setValue(balancegeneralcliente.getbienes_inmuebles());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_inmuebles);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_muebles=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_muebles.setValue(balancegeneralcliente.getbienes_muebles());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_muebles);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_activos_no_corrientes=new ParameterValue<Double>();
					parameterMaintenanceValueotros_activos_no_corrientes.setValue(balancegeneralcliente.getotros_activos_no_corrientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_activos_no_corrientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_activos_no_corrientes=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_activos_no_corrientes.setValue(balancegeneralcliente.gettotal_activos_no_corrientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_activos_no_corrientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueventas_mensuales=new ParameterValue<Double>();
					parameterMaintenanceValueventas_mensuales.setValue(balancegeneralcliente.getventas_mensuales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueventas_mensuales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_ventas_mensuales=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_ventas_mensuales.setValue(balancegeneralcliente.getcosto_ventas_mensuales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_ventas_mensuales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidad_bruta=new ParameterValue<Double>();
					parameterMaintenanceValueutilidad_bruta.setValue(balancegeneralcliente.getutilidad_bruta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidad_bruta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_operativos=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_operativos.setValue(balancegeneralcliente.getgastos_operativos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_operativos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesueldos=new ParameterValue<Double>();
					parameterMaintenanceValuesueldos.setValue(balancegeneralcliente.getsueldos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesueldos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios=new ParameterValue<Double>();
					parameterMaintenanceValueservicios.setValue(balancegeneralcliente.getservicios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuearriendos=new ParameterValue<Double>();
					parameterMaintenanceValuearriendos.setValue(balancegeneralcliente.getarriendos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearriendos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuestos=new ParameterValue<Double>();
					parameterMaintenanceValueimpuestos.setValue(balancegeneralcliente.getimpuestos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuestos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidad_operativa=new ParameterValue<Double>();
					parameterMaintenanceValueutilidad_operativa.setValue(balancegeneralcliente.getutilidad_operativa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidad_operativa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_familiares=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_familiares.setValue(balancegeneralcliente.getgastos_familiares());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_familiares);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueexcedente_antes_dividendos=new ParameterValue<Double>();
					parameterMaintenanceValueexcedente_antes_dividendos.setValue(balancegeneralcliente.getexcedente_antes_dividendos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueexcedente_antes_dividendos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedividendos_bancos_otros=new ParameterValue<Double>();
					parameterMaintenanceValuedividendos_bancos_otros.setValue(balancegeneralcliente.getdividendos_bancos_otros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedividendos_bancos_otros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueexedente_neto_mensual=new ParameterValue<Double>();
					parameterMaintenanceValueexedente_neto_mensual.setValue(balancegeneralcliente.getexedente_neto_mensual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueexedente_neto_mensual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedeudas_bancarias=new ParameterValue<Double>();
					parameterMaintenanceValuedeudas_bancarias.setValue(balancegeneralcliente.getdeudas_bancarias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedeudas_bancarias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecuentas_por_pagar=new ParameterValue<Double>();
					parameterMaintenanceValuecuentas_por_pagar.setValue(balancegeneralcliente.getcuentas_por_pagar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecuentas_por_pagar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueanticipos_recibos=new ParameterValue<Double>();
					parameterMaintenanceValueanticipos_recibos.setValue(balancegeneralcliente.getanticipos_recibos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanticipos_recibos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotras_cuentas_por_pagar=new ParameterValue<Double>();
					parameterMaintenanceValueotras_cuentas_por_pagar.setValue(balancegeneralcliente.getotras_cuentas_por_pagar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotras_cuentas_por_pagar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotras_deudas_familiares=new ParameterValue<Double>();
					parameterMaintenanceValueotras_deudas_familiares.setValue(balancegeneralcliente.getotras_deudas_familiares());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotras_deudas_familiares);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_pasivo_corriente=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_pasivo_corriente.setValue(balancegeneralcliente.gettotal_pasivo_corriente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_pasivo_corriente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedeudas_bancarias_largo_plazo=new ParameterValue<Double>();
					parameterMaintenanceValuedeudas_bancarias_largo_plazo.setValue(balancegeneralcliente.getdeudas_bancarias_largo_plazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedeudas_bancarias_largo_plazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_pasivos_largo_plazo=new ParameterValue<Double>();
					parameterMaintenanceValueotros_pasivos_largo_plazo.setValue(balancegeneralcliente.getotros_pasivos_largo_plazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_pasivos_largo_plazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_pasivo_no_corriente=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_pasivo_no_corriente.setValue(balancegeneralcliente.gettotal_pasivo_no_corriente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_pasivo_no_corriente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_pasivo=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_pasivo.setValue(balancegeneralcliente.gettotal_pasivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_pasivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepatrimonio=new ParameterValue<Double>();
					parameterMaintenanceValuepatrimonio.setValue(balancegeneralcliente.getpatrimonio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepatrimonio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(balancegeneralcliente.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!balancegeneralcliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(balancegeneralcliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(balancegeneralcliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(balancegeneralcliente.getId());
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
	
	public void setIsNewIsChangedFalseBalanceGeneralCliente(BalanceGeneralCliente balancegeneralcliente)throws Exception  {		
		balancegeneralcliente.setIsNew(false);
		balancegeneralcliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseBalanceGeneralClientes(List<BalanceGeneralCliente> balancegeneralclientes)throws Exception  {				
		for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes) {
			balancegeneralcliente.setIsNew(false);
			balancegeneralcliente.setIsChanged(false);
		}
	}
	
	public void generarExportarBalanceGeneralCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
