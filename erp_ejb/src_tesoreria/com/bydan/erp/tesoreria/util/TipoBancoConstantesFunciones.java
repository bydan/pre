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


import com.bydan.erp.tesoreria.util.TipoBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoBancoConstantesFunciones extends TipoBancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoBanco"+TipoBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoBancoConstantesFunciones.SCHEMA+"_"+TipoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoBancoConstantesFunciones.SCHEMA+"_"+TipoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoBancoConstantesFunciones.SCHEMA+"_"+TipoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoBancoConstantesFunciones.SCHEMA+"_"+TipoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Banco";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoBanco";
	public static final String OBJECTNAME="tipobanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipobanco from "+TipoBancoConstantesFunciones.SPERSISTENCENAME+" tipobanco";
	public static String QUERYSELECTNATIVE="select "+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME+".id,"+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME+".version_row,"+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME+".id_empresa,"+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME+".nombre,"+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME+".codigo_sri,"+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME+".es_defecto from "+TipoBancoConstantesFunciones.SCHEMA+"."+TipoBancoConstantesFunciones.TABLENAME;//+" as "+TipoBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoBancoConstantesFuncionesAdditional tipobancoConstantesFuncionesAdditional=null;
	
	public TipoBancoConstantesFuncionesAdditional getTipoBancoConstantesFuncionesAdditional() {
		return this.tipobancoConstantesFuncionesAdditional;
	}
	
	public void setTipoBancoConstantesFuncionesAdditional(TipoBancoConstantesFuncionesAdditional tipobancoConstantesFuncionesAdditional) {
		try {
			this.tipobancoConstantesFuncionesAdditional=tipobancoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String CODIGOSRI= "codigo_sri";
    public static final String ESDEFECTO= "es_defecto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOSRI= "Codigo Sri";
		public static final String LABEL_CODIGOSRI_LOWER= "Codigo Sri";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_SRI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SRI=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoBancoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoBancoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoBancoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoBancoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoBancoConstantesFunciones.CODIGOSRI)) {sLabelColumna=TipoBancoConstantesFunciones.LABEL_CODIGOSRI;}
		if(sNombreColumna.equals(TipoBancoConstantesFunciones.ESDEFECTO)) {sLabelColumna=TipoBancoConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_defectoDescripcion(TipoBanco tipobanco) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipobanco.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(TipoBanco tipobanco) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipobanco.getId(),tipobanco.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getTipoBancoDescripcion(TipoBanco tipobanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipobanco !=null/* && tipobanco.getId()!=0*/) {
			sDescripcion=tipobanco.getnombre();//tipobancotipobanco.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoBancoDescripcionDetallado(TipoBanco tipobanco) {
		String sDescripcion="";
			
		sDescripcion+=TipoBancoConstantesFunciones.ID+"=";
		sDescripcion+=tipobanco.getId().toString()+",";
		sDescripcion+=TipoBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipobanco.getVersionRow().toString()+",";
		sDescripcion+=TipoBancoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipobanco.getid_empresa().toString()+",";
		sDescripcion+=TipoBancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipobanco.getnombre()+",";
		sDescripcion+=TipoBancoConstantesFunciones.CODIGOSRI+"=";
		sDescripcion+=tipobanco.getcodigo_sri()+",";
		sDescripcion+=TipoBancoConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=tipobanco.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoBancoDescripcion(TipoBanco tipobanco,String sValor) throws Exception {			
		if(tipobanco !=null) {
			tipobanco.setnombre(sValor);;//tipobancotipobanco.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoBanco(TipoBanco tipobanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipobanco.setnombre(tipobanco.getnombre().trim());
		tipobanco.setcodigo_sri(tipobanco.getcodigo_sri().trim());
	}
	
	public static void quitarEspaciosTipoBancos(List<TipoBanco> tipobancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoBanco tipobanco: tipobancos) {
			tipobanco.setnombre(tipobanco.getnombre().trim());
			tipobanco.setcodigo_sri(tipobanco.getcodigo_sri().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBanco(TipoBanco tipobanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipobanco.getConCambioAuxiliar()) {
			tipobanco.setIsDeleted(tipobanco.getIsDeletedAuxiliar());	
			tipobanco.setIsNew(tipobanco.getIsNewAuxiliar());	
			tipobanco.setIsChanged(tipobanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipobanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipobanco.setIsDeletedAuxiliar(false);	
			tipobanco.setIsNewAuxiliar(false);	
			tipobanco.setIsChangedAuxiliar(false);
			
			tipobanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancos(List<TipoBanco> tipobancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoBanco tipobanco : tipobancos) {
			if(conAsignarBase && tipobanco.getConCambioAuxiliar()) {
				tipobanco.setIsDeleted(tipobanco.getIsDeletedAuxiliar());	
				tipobanco.setIsNew(tipobanco.getIsNewAuxiliar());	
				tipobanco.setIsChanged(tipobanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipobanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipobanco.setIsDeletedAuxiliar(false);	
				tipobanco.setIsNewAuxiliar(false);	
				tipobanco.setIsChangedAuxiliar(false);
				
				tipobanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoBanco(TipoBanco tipobanco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoBancos(List<TipoBanco> tipobancos,Boolean conEnteros) throws Exception  {
		
		for(TipoBanco tipobanco: tipobancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoBanco(List<TipoBanco> tipobancos,TipoBanco tipobancoAux) throws Exception  {
		TipoBancoConstantesFunciones.InicializarValoresTipoBanco(tipobancoAux,true);
		
		for(TipoBanco tipobanco: tipobancos) {
			if(tipobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoBancoConstantesFunciones.getArrayColumnasGlobalesTipoBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoBancoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoBancoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoBanco> tipobancos,TipoBanco tipobanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoBanco tipobancoAux: tipobancos) {
			if(tipobancoAux!=null && tipobanco!=null) {
				if((tipobancoAux.getId()==null && tipobanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipobancoAux.getId()!=null && tipobanco.getId()!=null){
					if(tipobancoAux.getId().equals(tipobanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoBanco(List<TipoBanco> tipobancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoBanco tipobanco: tipobancos) {			
			if(tipobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoBancoConstantesFunciones.LABEL_ID, TipoBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoConstantesFunciones.LABEL_VERSIONROW, TipoBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoConstantesFunciones.LABEL_IDEMPRESA, TipoBancoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoConstantesFunciones.LABEL_NOMBRE, TipoBancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoConstantesFunciones.LABEL_CODIGOSRI, TipoBancoConstantesFunciones.CODIGOSRI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoConstantesFunciones.LABEL_ESDEFECTO, TipoBancoConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoConstantesFunciones.CODIGOSRI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBanco() throws Exception  {
		return TipoBancoConstantesFunciones.getTiposSeleccionarTipoBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBanco(Boolean conFk) throws Exception  {
		return TipoBancoConstantesFunciones.getTiposSeleccionarTipoBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoBancoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoBancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoConstantesFunciones.LABEL_CODIGOSRI);
			reporte.setsDescripcion(TipoBancoConstantesFunciones.LABEL_CODIGOSRI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(TipoBancoConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBanco(TipoBanco tipobancoAux) throws Exception {
		
			tipobancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobancoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBanco(List<TipoBanco> tipobancosTemp) throws Exception {
		for(TipoBanco tipobancoAux:tipobancosTemp) {
			
			tipobancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobancoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoConstantesFunciones.getClassesRelationshipsOfTipoBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ImportarExportar.class));
				classes.add(new Classe(Banco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
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
	public static void actualizarLista(TipoBanco tipobanco,List<TipoBanco> tipobancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoBanco tipobancoEncontrado=null;
			
			for(TipoBanco tipobancoLocal:tipobancos) {
				if(tipobancoLocal.getId().equals(tipobanco.getId())) {
					tipobancoEncontrado=tipobancoLocal;
					
					tipobancoLocal.setIsChanged(tipobanco.getIsChanged());
					tipobancoLocal.setIsNew(tipobanco.getIsNew());
					tipobancoLocal.setIsDeleted(tipobanco.getIsDeleted());
					
					tipobancoLocal.setGeneralEntityOriginal(tipobanco.getGeneralEntityOriginal());
					
					tipobancoLocal.setId(tipobanco.getId());	
					tipobancoLocal.setVersionRow(tipobanco.getVersionRow());	
					tipobancoLocal.setid_empresa(tipobanco.getid_empresa());	
					tipobancoLocal.setnombre(tipobanco.getnombre());	
					tipobancoLocal.setcodigo_sri(tipobanco.getcodigo_sri());	
					tipobancoLocal.setes_defecto(tipobanco.getes_defecto());	
					
					
					tipobancoLocal.setBancos(tipobanco.getBancos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipobanco.getIsDeleted()) {
				if(!existe) {
					tipobancos.add(tipobanco);
				}
			} else {
				if(tipobancoEncontrado!=null && permiteQuitar)  {
					tipobancos.remove(tipobancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoBanco tipobanco,List<TipoBanco> tipobancos) throws Exception {
		try	{			
			for(TipoBanco tipobancoLocal:tipobancos) {
				if(tipobancoLocal.getId().equals(tipobanco.getId())) {
					tipobancoLocal.setIsSelected(tipobanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoBanco(List<TipoBanco> tipobancosAux) throws Exception {
		//this.tipobancosAux=tipobancosAux;
		
		for(TipoBanco tipobancoAux:tipobancosAux) {
			if(tipobancoAux.getIsChanged()) {
				tipobancoAux.setIsChanged(false);
			}		
			
			if(tipobancoAux.getIsNew()) {
				tipobancoAux.setIsNew(false);
			}	
			
			if(tipobancoAux.getIsDeleted()) {
				tipobancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoBanco(TipoBanco tipobancoAux) throws Exception {
		//this.tipobancoAux=tipobancoAux;
		
			if(tipobancoAux.getIsChanged()) {
				tipobancoAux.setIsChanged(false);
			}		
			
			if(tipobancoAux.getIsNew()) {
				tipobancoAux.setIsNew(false);
			}	
			
			if(tipobancoAux.getIsDeleted()) {
				tipobancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoBanco tipobancoAsignar,TipoBanco tipobanco) throws Exception {
		tipobancoAsignar.setId(tipobanco.getId());	
		tipobancoAsignar.setVersionRow(tipobanco.getVersionRow());	
		tipobancoAsignar.setid_empresa(tipobanco.getid_empresa());
		tipobancoAsignar.setempresa_descripcion(tipobanco.getempresa_descripcion());	
		tipobancoAsignar.setnombre(tipobanco.getnombre());	
		tipobancoAsignar.setcodigo_sri(tipobanco.getcodigo_sri());	
		tipobancoAsignar.setes_defecto(tipobanco.getes_defecto());	
	}
	
	public static void inicializarTipoBanco(TipoBanco tipobanco) throws Exception {
		try {
				tipobanco.setId(0L);	
					
				tipobanco.setid_empresa(-1L);	
				tipobanco.setnombre("");	
				tipobanco.setcodigo_sri("");	
				tipobanco.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoConstantesFunciones.LABEL_CODIGOSRI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoBanco(String sTipo,Row row,Workbook workbook,TipoBanco tipobanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobanco.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobanco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobanco.getcodigo_sri());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipobanco.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoBanco() {
		return this.sFinalQueryTipoBanco;
	}
	
	public void setsFinalQueryTipoBanco(String sFinalQueryTipoBanco) {
		this.sFinalQueryTipoBanco= sFinalQueryTipoBanco;
	}
	
	public Border resaltarSeleccionarTipoBanco=null;
	
	public Border setResaltarSeleccionarTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoBanco() {
		return this.resaltarSeleccionarTipoBanco;
	}
	
	public void setResaltarSeleccionarTipoBanco(Border borderResaltarSeleccionarTipoBanco) {
		this.resaltarSeleccionarTipoBanco= borderResaltarSeleccionarTipoBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoBanco=null;
	public Boolean mostraridTipoBanco=true;
	public Boolean activaridTipoBanco=true;

	public Border resaltarid_empresaTipoBanco=null;
	public Boolean mostrarid_empresaTipoBanco=true;
	public Boolean activarid_empresaTipoBanco=true;
	public Boolean cargarid_empresaTipoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoBanco=false;//ConEventDepend=true

	public Border resaltarnombreTipoBanco=null;
	public Boolean mostrarnombreTipoBanco=true;
	public Boolean activarnombreTipoBanco=true;

	public Border resaltarcodigo_sriTipoBanco=null;
	public Boolean mostrarcodigo_sriTipoBanco=true;
	public Boolean activarcodigo_sriTipoBanco=true;

	public Border resaltares_defectoTipoBanco=null;
	public Boolean mostrares_defectoTipoBanco=true;
	public Boolean activares_defectoTipoBanco=true;

	
	

	public Border setResaltaridTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltar);
		
		this.resaltaridTipoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoBanco() {
		return this.resaltaridTipoBanco;
	}

	public void setResaltaridTipoBanco(Border borderResaltar) {
		this.resaltaridTipoBanco= borderResaltar;
	}

	public Boolean getMostraridTipoBanco() {
		return this.mostraridTipoBanco;
	}

	public void setMostraridTipoBanco(Boolean mostraridTipoBanco) {
		this.mostraridTipoBanco= mostraridTipoBanco;
	}

	public Boolean getActivaridTipoBanco() {
		return this.activaridTipoBanco;
	}

	public void setActivaridTipoBanco(Boolean activaridTipoBanco) {
		this.activaridTipoBanco= activaridTipoBanco;
	}

	public Border setResaltarid_empresaTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoBanco() {
		return this.resaltarid_empresaTipoBanco;
	}

	public void setResaltarid_empresaTipoBanco(Border borderResaltar) {
		this.resaltarid_empresaTipoBanco= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoBanco() {
		return this.mostrarid_empresaTipoBanco;
	}

	public void setMostrarid_empresaTipoBanco(Boolean mostrarid_empresaTipoBanco) {
		this.mostrarid_empresaTipoBanco= mostrarid_empresaTipoBanco;
	}

	public Boolean getActivarid_empresaTipoBanco() {
		return this.activarid_empresaTipoBanco;
	}

	public void setActivarid_empresaTipoBanco(Boolean activarid_empresaTipoBanco) {
		this.activarid_empresaTipoBanco= activarid_empresaTipoBanco;
	}

	public Boolean getCargarid_empresaTipoBanco() {
		return this.cargarid_empresaTipoBanco;
	}

	public void setCargarid_empresaTipoBanco(Boolean cargarid_empresaTipoBanco) {
		this.cargarid_empresaTipoBanco= cargarid_empresaTipoBanco;
	}

	public Border setResaltarnombreTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltar);
		
		this.resaltarnombreTipoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoBanco() {
		return this.resaltarnombreTipoBanco;
	}

	public void setResaltarnombreTipoBanco(Border borderResaltar) {
		this.resaltarnombreTipoBanco= borderResaltar;
	}

	public Boolean getMostrarnombreTipoBanco() {
		return this.mostrarnombreTipoBanco;
	}

	public void setMostrarnombreTipoBanco(Boolean mostrarnombreTipoBanco) {
		this.mostrarnombreTipoBanco= mostrarnombreTipoBanco;
	}

	public Boolean getActivarnombreTipoBanco() {
		return this.activarnombreTipoBanco;
	}

	public void setActivarnombreTipoBanco(Boolean activarnombreTipoBanco) {
		this.activarnombreTipoBanco= activarnombreTipoBanco;
	}

	public Border setResaltarcodigo_sriTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltar);
		
		this.resaltarcodigo_sriTipoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sriTipoBanco() {
		return this.resaltarcodigo_sriTipoBanco;
	}

	public void setResaltarcodigo_sriTipoBanco(Border borderResaltar) {
		this.resaltarcodigo_sriTipoBanco= borderResaltar;
	}

	public Boolean getMostrarcodigo_sriTipoBanco() {
		return this.mostrarcodigo_sriTipoBanco;
	}

	public void setMostrarcodigo_sriTipoBanco(Boolean mostrarcodigo_sriTipoBanco) {
		this.mostrarcodigo_sriTipoBanco= mostrarcodigo_sriTipoBanco;
	}

	public Boolean getActivarcodigo_sriTipoBanco() {
		return this.activarcodigo_sriTipoBanco;
	}

	public void setActivarcodigo_sriTipoBanco(Boolean activarcodigo_sriTipoBanco) {
		this.activarcodigo_sriTipoBanco= activarcodigo_sriTipoBanco;
	}

	public Border setResaltares_defectoTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltar);
		
		this.resaltares_defectoTipoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoTipoBanco() {
		return this.resaltares_defectoTipoBanco;
	}

	public void setResaltares_defectoTipoBanco(Border borderResaltar) {
		this.resaltares_defectoTipoBanco= borderResaltar;
	}

	public Boolean getMostrares_defectoTipoBanco() {
		return this.mostrares_defectoTipoBanco;
	}

	public void setMostrares_defectoTipoBanco(Boolean mostrares_defectoTipoBanco) {
		this.mostrares_defectoTipoBanco= mostrares_defectoTipoBanco;
	}

	public Boolean getActivares_defectoTipoBanco() {
		return this.activares_defectoTipoBanco;
	}

	public void setActivares_defectoTipoBanco(Boolean activares_defectoTipoBanco) {
		this.activares_defectoTipoBanco= activares_defectoTipoBanco;
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
		
		
		this.setMostraridTipoBanco(esInicial);
		this.setMostrarid_empresaTipoBanco(esInicial);
		this.setMostrarnombreTipoBanco(esInicial);
		this.setMostrarcodigo_sriTipoBanco(esInicial);
		this.setMostrares_defectoTipoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoConstantesFunciones.ID)) {
				this.setMostraridTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.CODIGOSRI)) {
				this.setMostrarcodigo_sriTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoTipoBanco(esAsigna);
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
		
		
		this.setActivaridTipoBanco(esInicial);
		this.setActivarid_empresaTipoBanco(esInicial);
		this.setActivarnombreTipoBanco(esInicial);
		this.setActivarcodigo_sriTipoBanco(esInicial);
		this.setActivares_defectoTipoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoConstantesFunciones.ID)) {
				this.setActivaridTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.CODIGOSRI)) {
				this.setActivarcodigo_sriTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoTipoBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoBanco(esInicial);
		this.setResaltarid_empresaTipoBanco(esInicial);
		this.setResaltarnombreTipoBanco(esInicial);
		this.setResaltarcodigo_sriTipoBanco(esInicial);
		this.setResaltares_defectoTipoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoConstantesFunciones.ID)) {
				this.setResaltaridTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.CODIGOSRI)) {
				this.setResaltarcodigo_sriTipoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoTipoBanco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBancoTipoBanco=null;

	public Border getResaltarBancoTipoBanco() {
		return this.resaltarBancoTipoBanco;
	}

	public void setResaltarBancoTipoBanco(Border borderResaltarBanco) {
		if(borderResaltarBanco!=null) {
			this.resaltarBancoTipoBanco= borderResaltarBanco;
		}
	}

	public Border setResaltarBancoTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltarBanco=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipobancoBeanSwingJInternalFrame.jTtoolBarTipoBanco.setBorder(borderResaltarBanco);
			
		this.resaltarBancoTipoBanco= borderResaltarBanco;

		 return borderResaltarBanco;
	}



	public Boolean mostrarBancoTipoBanco=true;

	public Boolean getMostrarBancoTipoBanco() {
		return this.mostrarBancoTipoBanco;
	}

	public void setMostrarBancoTipoBanco(Boolean visibilidadResaltarBanco) {
		this.mostrarBancoTipoBanco= visibilidadResaltarBanco;
	}



	public Boolean activarBancoTipoBanco=true;

	public Boolean gethabilitarResaltarBancoTipoBanco() {
		return this.activarBancoTipoBanco;
	}

	public void setActivarBancoTipoBanco(Boolean habilitarResaltarBanco) {
		this.activarBancoTipoBanco= habilitarResaltarBanco;
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

		this.setMostrarBancoTipoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Banco.class)) {
				this.setMostrarBancoTipoBanco(esAsigna);
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

		this.setActivarBancoTipoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Banco.class)) {
				this.setActivarBancoTipoBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBancoTipoBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Banco.class)) {
				this.setResaltarBancoTipoBanco(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoBanco=true;

	public Boolean getMostrarBusquedaPorNombreTipoBanco() {
		return this.mostrarBusquedaPorNombreTipoBanco;
	}

	public void setMostrarBusquedaPorNombreTipoBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoBanco=true;

	public Boolean getMostrarFK_IdEmpresaTipoBanco() {
		return this.mostrarFK_IdEmpresaTipoBanco;
	}

	public void setMostrarFK_IdEmpresaTipoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoBanco= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoBanco=true;

	public Boolean getActivarBusquedaPorNombreTipoBanco() {
		return this.activarBusquedaPorNombreTipoBanco;
	}

	public void setActivarBusquedaPorNombreTipoBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoBanco=true;

	public Boolean getActivarFK_IdEmpresaTipoBanco() {
		return this.activarFK_IdEmpresaTipoBanco;
	}

	public void setActivarFK_IdEmpresaTipoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoBanco= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoBanco=null;

	public Border getResaltarBusquedaPorNombreTipoBanco() {
		return this.resaltarBusquedaPorNombreTipoBanco;
	}

	public void setResaltarBusquedaPorNombreTipoBanco(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoBanco= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoBanco=null;

	public Border getResaltarFK_IdEmpresaTipoBanco() {
		return this.resaltarFK_IdEmpresaTipoBanco;
	}

	public void setResaltarFK_IdEmpresaTipoBanco(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoBanco= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoBeanSwingJInternalFrame tipobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoBanco= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}