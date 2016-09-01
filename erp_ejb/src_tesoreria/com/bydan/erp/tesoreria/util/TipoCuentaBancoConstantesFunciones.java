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
package com.bydan.erp.tesoreria.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.tesoreria.util.TipoCuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCuentaBancoConstantesFunciones extends TipoCuentaBancoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="TipoCuentaBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCuentaBanco"+TipoCuentaBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCuentaBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCuentaBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCuentaBancoConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCuentaBancoConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCuentaBancoConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCuentaBancoConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCuentaBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCuentaBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCuentaBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCuentaBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cuenta Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cuenta Banco";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cuenta Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCuentaBanco";
	public static final String OBJECTNAME="tipocuentabanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_cuenta_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocuentabanco from "+TipoCuentaBancoConstantesFunciones.SPERSISTENCENAME+" tipocuentabanco";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaBancoConstantesFunciones.SCHEMA+"."+TipoCuentaBancoConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoConstantesFunciones.SCHEMA+"."+TipoCuentaBancoConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoConstantesFunciones.SCHEMA+"."+TipoCuentaBancoConstantesFunciones.TABLENAME+".id_empresa,"+TipoCuentaBancoConstantesFunciones.SCHEMA+"."+TipoCuentaBancoConstantesFunciones.TABLENAME+".codigo,"+TipoCuentaBancoConstantesFunciones.SCHEMA+"."+TipoCuentaBancoConstantesFunciones.TABLENAME+".nombre from "+TipoCuentaBancoConstantesFunciones.SCHEMA+"."+TipoCuentaBancoConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCuentaBancoConstantesFuncionesAdditional tipocuentabancoConstantesFuncionesAdditional=null;
	
	public TipoCuentaBancoConstantesFuncionesAdditional getTipoCuentaBancoConstantesFuncionesAdditional() {
		return this.tipocuentabancoConstantesFuncionesAdditional;
	}
	
	public void setTipoCuentaBancoConstantesFuncionesAdditional(TipoCuentaBancoConstantesFuncionesAdditional tipocuentabancoConstantesFuncionesAdditional) {
		try {
			this.tipocuentabancoConstantesFuncionesAdditional=tipocuentabancoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoCuentaBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCuentaBancoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCuentaBancoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCuentaBancoConstantesFunciones.CODIGO)) {sLabelColumna=TipoCuentaBancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCuentaBancoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCuentaBancoConstantesFunciones.LABEL_NOMBRE;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
	
	public static String getTipoCuentaBancoDescripcion(TipoCuentaBanco tipocuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocuentabanco !=null/* && tipocuentabanco.getId()!=0*/) {
			sDescripcion=tipocuentabanco.getcodigo();//tipocuentabancotipocuentabanco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCuentaBancoDescripcionDetallado(TipoCuentaBanco tipocuentabanco) {
		String sDescripcion="";
			
		sDescripcion+=TipoCuentaBancoConstantesFunciones.ID+"=";
		sDescripcion+=tipocuentabanco.getId().toString()+",";
		sDescripcion+=TipoCuentaBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocuentabanco.getVersionRow().toString()+",";
		sDescripcion+=TipoCuentaBancoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocuentabanco.getid_empresa().toString()+",";
		sDescripcion+=TipoCuentaBancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocuentabanco.getcodigo()+",";
		sDescripcion+=TipoCuentaBancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocuentabanco.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCuentaBancoDescripcion(TipoCuentaBanco tipocuentabanco,String sValor) throws Exception {			
		if(tipocuentabanco !=null) {
			tipocuentabanco.setcodigo(sValor);;//tipocuentabancotipocuentabanco.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoCuentaBanco(TipoCuentaBanco tipocuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocuentabanco.setcodigo(tipocuentabanco.getcodigo().trim());
		tipocuentabanco.setnombre(tipocuentabanco.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCuentaBancos(List<TipoCuentaBanco> tipocuentabancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCuentaBanco tipocuentabanco: tipocuentabancos) {
			tipocuentabanco.setcodigo(tipocuentabanco.getcodigo().trim());
			tipocuentabanco.setnombre(tipocuentabanco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaBanco(TipoCuentaBanco tipocuentabanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocuentabanco.getConCambioAuxiliar()) {
			tipocuentabanco.setIsDeleted(tipocuentabanco.getIsDeletedAuxiliar());	
			tipocuentabanco.setIsNew(tipocuentabanco.getIsNewAuxiliar());	
			tipocuentabanco.setIsChanged(tipocuentabanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocuentabanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocuentabanco.setIsDeletedAuxiliar(false);	
			tipocuentabanco.setIsNewAuxiliar(false);	
			tipocuentabanco.setIsChangedAuxiliar(false);
			
			tipocuentabanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaBancos(List<TipoCuentaBanco> tipocuentabancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCuentaBanco tipocuentabanco : tipocuentabancos) {
			if(conAsignarBase && tipocuentabanco.getConCambioAuxiliar()) {
				tipocuentabanco.setIsDeleted(tipocuentabanco.getIsDeletedAuxiliar());	
				tipocuentabanco.setIsNew(tipocuentabanco.getIsNewAuxiliar());	
				tipocuentabanco.setIsChanged(tipocuentabanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocuentabanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocuentabanco.setIsDeletedAuxiliar(false);	
				tipocuentabanco.setIsNewAuxiliar(false);	
				tipocuentabanco.setIsChangedAuxiliar(false);
				
				tipocuentabanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCuentaBanco(TipoCuentaBanco tipocuentabanco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCuentaBancos(List<TipoCuentaBanco> tipocuentabancos,Boolean conEnteros) throws Exception  {
		
		for(TipoCuentaBanco tipocuentabanco: tipocuentabancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCuentaBanco(List<TipoCuentaBanco> tipocuentabancos,TipoCuentaBanco tipocuentabancoAux) throws Exception  {
		TipoCuentaBancoConstantesFunciones.InicializarValoresTipoCuentaBanco(tipocuentabancoAux,true);
		
		for(TipoCuentaBanco tipocuentabanco: tipocuentabancos) {
			if(tipocuentabanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCuentaBancoConstantesFunciones.getArrayColumnasGlobalesTipoCuentaBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCuentaBancoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCuentaBancoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCuentaBanco> tipocuentabancos,TipoCuentaBanco tipocuentabanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCuentaBanco tipocuentabancoAux: tipocuentabancos) {
			if(tipocuentabancoAux!=null && tipocuentabanco!=null) {
				if((tipocuentabancoAux.getId()==null && tipocuentabanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocuentabancoAux.getId()!=null && tipocuentabanco.getId()!=null){
					if(tipocuentabancoAux.getId().equals(tipocuentabanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCuentaBanco(List<TipoCuentaBanco> tipocuentabancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCuentaBanco tipocuentabanco: tipocuentabancos) {			
			if(tipocuentabanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCuentaBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCuentaBancoConstantesFunciones.LABEL_ID, TipoCuentaBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoConstantesFunciones.LABEL_VERSIONROW, TipoCuentaBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoConstantesFunciones.LABEL_IDEMPRESA, TipoCuentaBancoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoConstantesFunciones.LABEL_CODIGO, TipoCuentaBancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoConstantesFunciones.LABEL_NOMBRE, TipoCuentaBancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCuentaBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBanco() throws Exception  {
		return TipoCuentaBancoConstantesFunciones.getTiposSeleccionarTipoCuentaBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBanco(Boolean conFk) throws Exception  {
		return TipoCuentaBancoConstantesFunciones.getTiposSeleccionarTipoCuentaBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCuentaBancoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCuentaBancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCuentaBancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCuentaBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaBanco(TipoCuentaBanco tipocuentabancoAux) throws Exception {
		
			tipocuentabancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocuentabancoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaBanco(List<TipoCuentaBanco> tipocuentabancosTemp) throws Exception {
		for(TipoCuentaBanco tipocuentabancoAux:tipocuentabancosTemp) {
			
			tipocuentabancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocuentabancoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaBancoConstantesFunciones.getClassesRelationshipsOfTipoCuentaBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ReferenciaBancaria.class));
				classes.add(new Classe(TipoCuentaBancoGeneral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaBancaria.class)) {
						classes.add(new Classe(ReferenciaBancaria.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGeneral.class)) {
						classes.add(new Classe(TipoCuentaBancoGeneral.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaBancoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCuentaBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(TipoCuentaBancoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(TipoCuentaBancoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoCuentaBanco tipocuentabanco,List<TipoCuentaBanco> tipocuentabancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCuentaBanco tipocuentabancoEncontrado=null;
			
			for(TipoCuentaBanco tipocuentabancoLocal:tipocuentabancos) {
				if(tipocuentabancoLocal.getId().equals(tipocuentabanco.getId())) {
					tipocuentabancoEncontrado=tipocuentabancoLocal;
					
					tipocuentabancoLocal.setIsChanged(tipocuentabanco.getIsChanged());
					tipocuentabancoLocal.setIsNew(tipocuentabanco.getIsNew());
					tipocuentabancoLocal.setIsDeleted(tipocuentabanco.getIsDeleted());
					
					tipocuentabancoLocal.setGeneralEntityOriginal(tipocuentabanco.getGeneralEntityOriginal());
					
					tipocuentabancoLocal.setId(tipocuentabanco.getId());	
					tipocuentabancoLocal.setVersionRow(tipocuentabanco.getVersionRow());	
					tipocuentabancoLocal.setid_empresa(tipocuentabanco.getid_empresa());	
					tipocuentabancoLocal.setcodigo(tipocuentabanco.getcodigo());	
					tipocuentabancoLocal.setnombre(tipocuentabanco.getnombre());	
					
					
					tipocuentabancoLocal.setReferenciaBancarias(tipocuentabanco.getReferenciaBancarias());
					tipocuentabancoLocal.setTipoCuentaBancoGenerals(tipocuentabanco.getTipoCuentaBancoGenerals());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocuentabanco.getIsDeleted()) {
				if(!existe) {
					tipocuentabancos.add(tipocuentabanco);
				}
			} else {
				if(tipocuentabancoEncontrado!=null && permiteQuitar)  {
					tipocuentabancos.remove(tipocuentabancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCuentaBanco tipocuentabanco,List<TipoCuentaBanco> tipocuentabancos) throws Exception {
		try	{			
			for(TipoCuentaBanco tipocuentabancoLocal:tipocuentabancos) {
				if(tipocuentabancoLocal.getId().equals(tipocuentabanco.getId())) {
					tipocuentabancoLocal.setIsSelected(tipocuentabanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCuentaBanco(List<TipoCuentaBanco> tipocuentabancosAux) throws Exception {
		//this.tipocuentabancosAux=tipocuentabancosAux;
		
		for(TipoCuentaBanco tipocuentabancoAux:tipocuentabancosAux) {
			if(tipocuentabancoAux.getIsChanged()) {
				tipocuentabancoAux.setIsChanged(false);
			}		
			
			if(tipocuentabancoAux.getIsNew()) {
				tipocuentabancoAux.setIsNew(false);
			}	
			
			if(tipocuentabancoAux.getIsDeleted()) {
				tipocuentabancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCuentaBanco(TipoCuentaBanco tipocuentabancoAux) throws Exception {
		//this.tipocuentabancoAux=tipocuentabancoAux;
		
			if(tipocuentabancoAux.getIsChanged()) {
				tipocuentabancoAux.setIsChanged(false);
			}		
			
			if(tipocuentabancoAux.getIsNew()) {
				tipocuentabancoAux.setIsNew(false);
			}	
			
			if(tipocuentabancoAux.getIsDeleted()) {
				tipocuentabancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCuentaBanco tipocuentabancoAsignar,TipoCuentaBanco tipocuentabanco) throws Exception {
		tipocuentabancoAsignar.setId(tipocuentabanco.getId());	
		tipocuentabancoAsignar.setVersionRow(tipocuentabanco.getVersionRow());	
		tipocuentabancoAsignar.setid_empresa(tipocuentabanco.getid_empresa());
		tipocuentabancoAsignar.setempresa_descripcion(tipocuentabanco.getempresa_descripcion());	
		tipocuentabancoAsignar.setcodigo(tipocuentabanco.getcodigo());	
		tipocuentabancoAsignar.setnombre(tipocuentabanco.getnombre());	
	}
	
	public static void inicializarTipoCuentaBanco(TipoCuentaBanco tipocuentabanco) throws Exception {
		try {
				tipocuentabanco.setId(0L);	
					
				tipocuentabanco.setid_empresa(-1L);	
				tipocuentabanco.setcodigo("");	
				tipocuentabanco.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCuentaBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCuentaBanco(String sTipo,Row row,Workbook workbook,TipoCuentaBanco tipocuentabanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabanco.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabanco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabanco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCuentaBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCuentaBanco() {
		return this.sFinalQueryTipoCuentaBanco;
	}
	
	public void setsFinalQueryTipoCuentaBanco(String sFinalQueryTipoCuentaBanco) {
		this.sFinalQueryTipoCuentaBanco= sFinalQueryTipoCuentaBanco;
	}
	
	public Border resaltarSeleccionarTipoCuentaBanco=null;
	
	public Border setResaltarSeleccionarTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCuentaBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCuentaBanco() {
		return this.resaltarSeleccionarTipoCuentaBanco;
	}
	
	public void setResaltarSeleccionarTipoCuentaBanco(Border borderResaltarSeleccionarTipoCuentaBanco) {
		this.resaltarSeleccionarTipoCuentaBanco= borderResaltarSeleccionarTipoCuentaBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCuentaBanco=null;
	public Boolean mostraridTipoCuentaBanco=true;
	public Boolean activaridTipoCuentaBanco=true;

	public Border resaltarid_empresaTipoCuentaBanco=null;
	public Boolean mostrarid_empresaTipoCuentaBanco=true;
	public Boolean activarid_empresaTipoCuentaBanco=true;
	public Boolean cargarid_empresaTipoCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCuentaBanco=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCuentaBanco=null;
	public Boolean mostrarcodigoTipoCuentaBanco=true;
	public Boolean activarcodigoTipoCuentaBanco=true;

	public Border resaltarnombreTipoCuentaBanco=null;
	public Boolean mostrarnombreTipoCuentaBanco=true;
	public Boolean activarnombreTipoCuentaBanco=true;

	
	

	public Border setResaltaridTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltaridTipoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCuentaBanco() {
		return this.resaltaridTipoCuentaBanco;
	}

	public void setResaltaridTipoCuentaBanco(Border borderResaltar) {
		this.resaltaridTipoCuentaBanco= borderResaltar;
	}

	public Boolean getMostraridTipoCuentaBanco() {
		return this.mostraridTipoCuentaBanco;
	}

	public void setMostraridTipoCuentaBanco(Boolean mostraridTipoCuentaBanco) {
		this.mostraridTipoCuentaBanco= mostraridTipoCuentaBanco;
	}

	public Boolean getActivaridTipoCuentaBanco() {
		return this.activaridTipoCuentaBanco;
	}

	public void setActivaridTipoCuentaBanco(Boolean activaridTipoCuentaBanco) {
		this.activaridTipoCuentaBanco= activaridTipoCuentaBanco;
	}

	public Border setResaltarid_empresaTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCuentaBanco() {
		return this.resaltarid_empresaTipoCuentaBanco;
	}

	public void setResaltarid_empresaTipoCuentaBanco(Border borderResaltar) {
		this.resaltarid_empresaTipoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCuentaBanco() {
		return this.mostrarid_empresaTipoCuentaBanco;
	}

	public void setMostrarid_empresaTipoCuentaBanco(Boolean mostrarid_empresaTipoCuentaBanco) {
		this.mostrarid_empresaTipoCuentaBanco= mostrarid_empresaTipoCuentaBanco;
	}

	public Boolean getActivarid_empresaTipoCuentaBanco() {
		return this.activarid_empresaTipoCuentaBanco;
	}

	public void setActivarid_empresaTipoCuentaBanco(Boolean activarid_empresaTipoCuentaBanco) {
		this.activarid_empresaTipoCuentaBanco= activarid_empresaTipoCuentaBanco;
	}

	public Boolean getCargarid_empresaTipoCuentaBanco() {
		return this.cargarid_empresaTipoCuentaBanco;
	}

	public void setCargarid_empresaTipoCuentaBanco(Boolean cargarid_empresaTipoCuentaBanco) {
		this.cargarid_empresaTipoCuentaBanco= cargarid_empresaTipoCuentaBanco;
	}

	public Border setResaltarcodigoTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCuentaBanco() {
		return this.resaltarcodigoTipoCuentaBanco;
	}

	public void setResaltarcodigoTipoCuentaBanco(Border borderResaltar) {
		this.resaltarcodigoTipoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCuentaBanco() {
		return this.mostrarcodigoTipoCuentaBanco;
	}

	public void setMostrarcodigoTipoCuentaBanco(Boolean mostrarcodigoTipoCuentaBanco) {
		this.mostrarcodigoTipoCuentaBanco= mostrarcodigoTipoCuentaBanco;
	}

	public Boolean getActivarcodigoTipoCuentaBanco() {
		return this.activarcodigoTipoCuentaBanco;
	}

	public void setActivarcodigoTipoCuentaBanco(Boolean activarcodigoTipoCuentaBanco) {
		this.activarcodigoTipoCuentaBanco= activarcodigoTipoCuentaBanco;
	}

	public Border setResaltarnombreTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCuentaBanco() {
		return this.resaltarnombreTipoCuentaBanco;
	}

	public void setResaltarnombreTipoCuentaBanco(Border borderResaltar) {
		this.resaltarnombreTipoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCuentaBanco() {
		return this.mostrarnombreTipoCuentaBanco;
	}

	public void setMostrarnombreTipoCuentaBanco(Boolean mostrarnombreTipoCuentaBanco) {
		this.mostrarnombreTipoCuentaBanco= mostrarnombreTipoCuentaBanco;
	}

	public Boolean getActivarnombreTipoCuentaBanco() {
		return this.activarnombreTipoCuentaBanco;
	}

	public void setActivarnombreTipoCuentaBanco(Boolean activarnombreTipoCuentaBanco) {
		this.activarnombreTipoCuentaBanco= activarnombreTipoCuentaBanco;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridTipoCuentaBanco(esInicial);
		this.setMostrarid_empresaTipoCuentaBanco(esInicial);
		this.setMostrarcodigoTipoCuentaBanco(esInicial);
		this.setMostrarnombreTipoCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.ID)) {
				this.setMostraridTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCuentaBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridTipoCuentaBanco(esInicial);
		this.setActivarid_empresaTipoCuentaBanco(esInicial);
		this.setActivarcodigoTipoCuentaBanco(esInicial);
		this.setActivarnombreTipoCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.ID)) {
				this.setActivaridTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCuentaBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCuentaBanco(esInicial);
		this.setResaltarid_empresaTipoCuentaBanco(esInicial);
		this.setResaltarcodigoTipoCuentaBanco(esInicial);
		this.setResaltarnombreTipoCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.ID)) {
				this.setResaltaridTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCuentaBanco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarReferenciaBancariaTipoCuentaBanco=null;

	public Border getResaltarReferenciaBancariaTipoCuentaBanco() {
		return this.resaltarReferenciaBancariaTipoCuentaBanco;
	}

	public void setResaltarReferenciaBancariaTipoCuentaBanco(Border borderResaltarReferenciaBancaria) {
		if(borderResaltarReferenciaBancaria!=null) {
			this.resaltarReferenciaBancariaTipoCuentaBanco= borderResaltarReferenciaBancaria;
		}
	}

	public Border setResaltarReferenciaBancariaTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaBancaria=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltarReferenciaBancaria);
			
		this.resaltarReferenciaBancariaTipoCuentaBanco= borderResaltarReferenciaBancaria;

		 return borderResaltarReferenciaBancaria;
	}



	public Boolean mostrarReferenciaBancariaTipoCuentaBanco=true;

	public Boolean getMostrarReferenciaBancariaTipoCuentaBanco() {
		return this.mostrarReferenciaBancariaTipoCuentaBanco;
	}

	public void setMostrarReferenciaBancariaTipoCuentaBanco(Boolean visibilidadResaltarReferenciaBancaria) {
		this.mostrarReferenciaBancariaTipoCuentaBanco= visibilidadResaltarReferenciaBancaria;
	}



	public Boolean activarReferenciaBancariaTipoCuentaBanco=true;

	public Boolean gethabilitarResaltarReferenciaBancariaTipoCuentaBanco() {
		return this.activarReferenciaBancariaTipoCuentaBanco;
	}

	public void setActivarReferenciaBancariaTipoCuentaBanco(Boolean habilitarResaltarReferenciaBancaria) {
		this.activarReferenciaBancariaTipoCuentaBanco= habilitarResaltarReferenciaBancaria;
	}


	public Border resaltarTipoCuentaBancoGeneralTipoCuentaBanco=null;

	public Border getResaltarTipoCuentaBancoGeneralTipoCuentaBanco() {
		return this.resaltarTipoCuentaBancoGeneralTipoCuentaBanco;
	}

	public void setResaltarTipoCuentaBancoGeneralTipoCuentaBanco(Border borderResaltarTipoCuentaBancoGeneral) {
		if(borderResaltarTipoCuentaBancoGeneral!=null) {
			this.resaltarTipoCuentaBancoGeneralTipoCuentaBanco= borderResaltarTipoCuentaBancoGeneral;
		}
	}

	public Border setResaltarTipoCuentaBancoGeneralTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltarTipoCuentaBancoGeneral=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoBeanSwingJInternalFrame.jTtoolBarTipoCuentaBanco.setBorder(borderResaltarTipoCuentaBancoGeneral);
			
		this.resaltarTipoCuentaBancoGeneralTipoCuentaBanco= borderResaltarTipoCuentaBancoGeneral;

		 return borderResaltarTipoCuentaBancoGeneral;
	}



	public Boolean mostrarTipoCuentaBancoGeneralTipoCuentaBanco=true;

	public Boolean getMostrarTipoCuentaBancoGeneralTipoCuentaBanco() {
		return this.mostrarTipoCuentaBancoGeneralTipoCuentaBanco;
	}

	public void setMostrarTipoCuentaBancoGeneralTipoCuentaBanco(Boolean visibilidadResaltarTipoCuentaBancoGeneral) {
		this.mostrarTipoCuentaBancoGeneralTipoCuentaBanco= visibilidadResaltarTipoCuentaBancoGeneral;
	}



	public Boolean activarTipoCuentaBancoGeneralTipoCuentaBanco=true;

	public Boolean gethabilitarResaltarTipoCuentaBancoGeneralTipoCuentaBanco() {
		return this.activarTipoCuentaBancoGeneralTipoCuentaBanco;
	}

	public void setActivarTipoCuentaBancoGeneralTipoCuentaBanco(Boolean habilitarResaltarTipoCuentaBancoGeneral) {
		this.activarTipoCuentaBancoGeneralTipoCuentaBanco= habilitarResaltarTipoCuentaBancoGeneral;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarReferenciaBancariaTipoCuentaBanco(esInicial);
		this.setMostrarTipoCuentaBancoGeneralTipoCuentaBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setMostrarReferenciaBancariaTipoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoCuentaBancoGeneral.class)) {
				this.setMostrarTipoCuentaBancoGeneralTipoCuentaBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarReferenciaBancariaTipoCuentaBanco(esInicial);
		this.setActivarTipoCuentaBancoGeneralTipoCuentaBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setActivarReferenciaBancariaTipoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoCuentaBancoGeneral.class)) {
				this.setActivarTipoCuentaBancoGeneralTipoCuentaBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarReferenciaBancariaTipoCuentaBanco(esInicial);
		this.setResaltarTipoCuentaBancoGeneralTipoCuentaBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setResaltarReferenciaBancariaTipoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoCuentaBancoGeneral.class)) {
				this.setResaltarTipoCuentaBancoGeneralTipoCuentaBanco(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoCuentaBanco=true;

	public Boolean getMostrarFK_IdEmpresaTipoCuentaBanco() {
		return this.mostrarFK_IdEmpresaTipoCuentaBanco;
	}

	public void setMostrarFK_IdEmpresaTipoCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCuentaBanco= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoCuentaBanco=true;

	public Boolean getActivarFK_IdEmpresaTipoCuentaBanco() {
		return this.activarFK_IdEmpresaTipoCuentaBanco;
	}

	public void setActivarFK_IdEmpresaTipoCuentaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCuentaBanco= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoCuentaBanco=null;

	public Border getResaltarFK_IdEmpresaTipoCuentaBanco() {
		return this.resaltarFK_IdEmpresaTipoCuentaBanco;
	}

	public void setResaltarFK_IdEmpresaTipoCuentaBanco(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCuentaBanco= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoBeanSwingJInternalFrame tipocuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCuentaBanco= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}