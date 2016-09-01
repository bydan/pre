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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.CabeceraSerieConstantesFunciones;
import com.bydan.erp.inventario.util.CabeceraSerieParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CabeceraSerieParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CabeceraSerieConstantesFunciones extends CabeceraSerieConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CabeceraSerie";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CabeceraSerie"+CabeceraSerieConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CabeceraSerieHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CabeceraSerieHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CabeceraSerieConstantesFunciones.SCHEMA+"_"+CabeceraSerieConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CabeceraSerieHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CabeceraSerieConstantesFunciones.SCHEMA+"_"+CabeceraSerieConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CabeceraSerieConstantesFunciones.SCHEMA+"_"+CabeceraSerieConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CabeceraSerieHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CabeceraSerieConstantesFunciones.SCHEMA+"_"+CabeceraSerieConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CabeceraSerieConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CabeceraSerieHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CabeceraSerieConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CabeceraSerieConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CabeceraSerieHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CabeceraSerieConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CabeceraSerieConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CabeceraSerieConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CabeceraSerieConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CabeceraSerieConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cabecera Seriees";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cabecera Serie";
	public static final String SCLASSWEBTITULO_LOWER="Cabecera Serie";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CabeceraSerie";
	public static final String OBJECTNAME="cabeceraserie";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="cabecera_serie";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cabeceraserie from "+CabeceraSerieConstantesFunciones.SPERSISTENCENAME+" cabeceraserie";
	public static String QUERYSELECTNATIVE="select "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".id,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".version_row,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".id_empresa,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".nombre,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".formula,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".con_formula,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".con_totalizar from "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME;//+" as "+CabeceraSerieConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CabeceraSerieConstantesFuncionesAdditional cabeceraserieConstantesFuncionesAdditional=null;
	
	public CabeceraSerieConstantesFuncionesAdditional getCabeceraSerieConstantesFuncionesAdditional() {
		return this.cabeceraserieConstantesFuncionesAdditional;
	}
	
	public void setCabeceraSerieConstantesFuncionesAdditional(CabeceraSerieConstantesFuncionesAdditional cabeceraserieConstantesFuncionesAdditional) {
		try {
			this.cabeceraserieConstantesFuncionesAdditional=cabeceraserieConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String FORMULA= "formula";
    public static final String CONFORMULA= "con_formula";
    public static final String CONTOTALIZAR= "con_totalizar";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FORMULA= "Formula";
		public static final String LABEL_FORMULA_LOWER= "Formula";
    	public static final String LABEL_CONFORMULA= "Con Formula";
		public static final String LABEL_CONFORMULA_LOWER= "Con Formula";
    	public static final String LABEL_CONTOTALIZAR= "Con Totalizar";
		public static final String LABEL_CONTOTALIZAR_LOWER= "Con Totalizar";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFORMULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMULA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCabeceraSerieLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CabeceraSerieConstantesFunciones.IDEMPRESA)) {sLabelColumna=CabeceraSerieConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CabeceraSerieConstantesFunciones.NOMBRE)) {sLabelColumna=CabeceraSerieConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CabeceraSerieConstantesFunciones.FORMULA)) {sLabelColumna=CabeceraSerieConstantesFunciones.LABEL_FORMULA;}
		if(sNombreColumna.equals(CabeceraSerieConstantesFunciones.CONFORMULA)) {sLabelColumna=CabeceraSerieConstantesFunciones.LABEL_CONFORMULA;}
		if(sNombreColumna.equals(CabeceraSerieConstantesFunciones.CONTOTALIZAR)) {sLabelColumna=CabeceraSerieConstantesFunciones.LABEL_CONTOTALIZAR;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getcon_formulaDescripcion(CabeceraSerie cabeceraserie) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cabeceraserie.getcon_formula()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_formulaHtmlDescripcion(CabeceraSerie cabeceraserie) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cabeceraserie.getId(),cabeceraserie.getcon_formula());

		return sDescripcion;
	}	
		
	public static String getcon_totalizarDescripcion(CabeceraSerie cabeceraserie) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cabeceraserie.getcon_totalizar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_totalizarHtmlDescripcion(CabeceraSerie cabeceraserie) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cabeceraserie.getId(),cabeceraserie.getcon_totalizar());

		return sDescripcion;
	}	
	
	public static String getCabeceraSerieDescripcion(CabeceraSerie cabeceraserie) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cabeceraserie !=null/* && cabeceraserie.getId()!=0*/) {
			sDescripcion=cabeceraserie.getnombre();//cabeceraseriecabeceraserie.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCabeceraSerieDescripcionDetallado(CabeceraSerie cabeceraserie) {
		String sDescripcion="";
			
		sDescripcion+=CabeceraSerieConstantesFunciones.ID+"=";
		sDescripcion+=cabeceraserie.getId().toString()+",";
		sDescripcion+=CabeceraSerieConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cabeceraserie.getVersionRow().toString()+",";
		sDescripcion+=CabeceraSerieConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cabeceraserie.getid_empresa().toString()+",";
		sDescripcion+=CabeceraSerieConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cabeceraserie.getnombre()+",";
		sDescripcion+=CabeceraSerieConstantesFunciones.FORMULA+"=";
		sDescripcion+=cabeceraserie.getformula()+",";
		sDescripcion+=CabeceraSerieConstantesFunciones.CONFORMULA+"=";
		sDescripcion+=cabeceraserie.getcon_formula().toString()+",";
		sDescripcion+=CabeceraSerieConstantesFunciones.CONTOTALIZAR+"=";
		sDescripcion+=cabeceraserie.getcon_totalizar().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCabeceraSerieDescripcion(CabeceraSerie cabeceraserie,String sValor) throws Exception {			
		if(cabeceraserie !=null) {
			cabeceraserie.setnombre(sValor);//cabeceraseriecabeceraserie.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosCabeceraSerie(CabeceraSerie cabeceraserie,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cabeceraserie.setnombre(cabeceraserie.getnombre().trim());
		cabeceraserie.setformula(cabeceraserie.getformula().trim());
	}
	
	public static void quitarEspaciosCabeceraSeries(List<CabeceraSerie> cabeceraseries,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CabeceraSerie cabeceraserie: cabeceraseries) {
			cabeceraserie.setnombre(cabeceraserie.getnombre().trim());
			cabeceraserie.setformula(cabeceraserie.getformula().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCabeceraSerie(CabeceraSerie cabeceraserie,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cabeceraserie.getConCambioAuxiliar()) {
			cabeceraserie.setIsDeleted(cabeceraserie.getIsDeletedAuxiliar());	
			cabeceraserie.setIsNew(cabeceraserie.getIsNewAuxiliar());	
			cabeceraserie.setIsChanged(cabeceraserie.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cabeceraserie.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cabeceraserie.setIsDeletedAuxiliar(false);	
			cabeceraserie.setIsNewAuxiliar(false);	
			cabeceraserie.setIsChangedAuxiliar(false);
			
			cabeceraserie.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCabeceraSeries(List<CabeceraSerie> cabeceraseries,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CabeceraSerie cabeceraserie : cabeceraseries) {
			if(conAsignarBase && cabeceraserie.getConCambioAuxiliar()) {
				cabeceraserie.setIsDeleted(cabeceraserie.getIsDeletedAuxiliar());	
				cabeceraserie.setIsNew(cabeceraserie.getIsNewAuxiliar());	
				cabeceraserie.setIsChanged(cabeceraserie.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cabeceraserie.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cabeceraserie.setIsDeletedAuxiliar(false);	
				cabeceraserie.setIsNewAuxiliar(false);	
				cabeceraserie.setIsChangedAuxiliar(false);
				
				cabeceraserie.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCabeceraSerie(CabeceraSerie cabeceraserie,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCabeceraSeries(List<CabeceraSerie> cabeceraseries,Boolean conEnteros) throws Exception  {
		
		for(CabeceraSerie cabeceraserie: cabeceraseries) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCabeceraSerie(List<CabeceraSerie> cabeceraseries,CabeceraSerie cabeceraserieAux) throws Exception  {
		CabeceraSerieConstantesFunciones.InicializarValoresCabeceraSerie(cabeceraserieAux,true);
		
		for(CabeceraSerie cabeceraserie: cabeceraseries) {
			if(cabeceraserie.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCabeceraSerie(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CabeceraSerieConstantesFunciones.getArrayColumnasGlobalesCabeceraSerie(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCabeceraSerie(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CabeceraSerieConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CabeceraSerieConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCabeceraSerie(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CabeceraSerie> cabeceraseries,CabeceraSerie cabeceraserie,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CabeceraSerie cabeceraserieAux: cabeceraseries) {
			if(cabeceraserieAux!=null && cabeceraserie!=null) {
				if((cabeceraserieAux.getId()==null && cabeceraserie.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cabeceraserieAux.getId()!=null && cabeceraserie.getId()!=null){
					if(cabeceraserieAux.getId().equals(cabeceraserie.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCabeceraSerie(List<CabeceraSerie> cabeceraseries) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CabeceraSerie cabeceraserie: cabeceraseries) {			
			if(cabeceraserie.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCabeceraSerie() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_ID, CabeceraSerieConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_VERSIONROW, CabeceraSerieConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_IDEMPRESA, CabeceraSerieConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_NOMBRE, CabeceraSerieConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_FORMULA, CabeceraSerieConstantesFunciones.FORMULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_CONFORMULA, CabeceraSerieConstantesFunciones.CONFORMULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CabeceraSerieConstantesFunciones.LABEL_CONTOTALIZAR, CabeceraSerieConstantesFunciones.CONTOTALIZAR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCabeceraSerie() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.FORMULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.CONFORMULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CabeceraSerieConstantesFunciones.CONTOTALIZAR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCabeceraSerie() throws Exception  {
		return CabeceraSerieConstantesFunciones.getTiposSeleccionarCabeceraSerie(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCabeceraSerie(Boolean conFk) throws Exception  {
		return CabeceraSerieConstantesFunciones.getTiposSeleccionarCabeceraSerie(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCabeceraSerie(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CabeceraSerieConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CabeceraSerieConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CabeceraSerieConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CabeceraSerieConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CabeceraSerieConstantesFunciones.LABEL_FORMULA);
			reporte.setsDescripcion(CabeceraSerieConstantesFunciones.LABEL_FORMULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CabeceraSerieConstantesFunciones.LABEL_CONFORMULA);
			reporte.setsDescripcion(CabeceraSerieConstantesFunciones.LABEL_CONFORMULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CabeceraSerieConstantesFunciones.LABEL_CONTOTALIZAR);
			reporte.setsDescripcion(CabeceraSerieConstantesFunciones.LABEL_CONTOTALIZAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCabeceraSerie(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCabeceraSerie(CabeceraSerie cabeceraserieAux) throws Exception {
		
			cabeceraserieAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cabeceraserieAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCabeceraSerie(List<CabeceraSerie> cabeceraseriesTemp) throws Exception {
		for(CabeceraSerie cabeceraserieAux:cabeceraseriesTemp) {
			
			cabeceraserieAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cabeceraserieAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCabeceraSerie(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCabeceraSerie(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCabeceraSerie(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CabeceraSerieConstantesFunciones.getClassesRelationshipsOfCabeceraSerie(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCabeceraSerie(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCabeceraSerie(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CabeceraSerieConstantesFunciones.getClassesRelationshipsFromStringsOfCabeceraSerie(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCabeceraSerie(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(CabeceraSerie cabeceraserie,List<CabeceraSerie> cabeceraseries,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CabeceraSerie cabeceraserieEncontrado=null;
			
			for(CabeceraSerie cabeceraserieLocal:cabeceraseries) {
				if(cabeceraserieLocal.getId().equals(cabeceraserie.getId())) {
					cabeceraserieEncontrado=cabeceraserieLocal;
					
					cabeceraserieLocal.setIsChanged(cabeceraserie.getIsChanged());
					cabeceraserieLocal.setIsNew(cabeceraserie.getIsNew());
					cabeceraserieLocal.setIsDeleted(cabeceraserie.getIsDeleted());
					
					cabeceraserieLocal.setGeneralEntityOriginal(cabeceraserie.getGeneralEntityOriginal());
					
					cabeceraserieLocal.setId(cabeceraserie.getId());	
					cabeceraserieLocal.setVersionRow(cabeceraserie.getVersionRow());	
					cabeceraserieLocal.setid_empresa(cabeceraserie.getid_empresa());	
					cabeceraserieLocal.setnombre(cabeceraserie.getnombre());	
					cabeceraserieLocal.setformula(cabeceraserie.getformula());	
					cabeceraserieLocal.setcon_formula(cabeceraserie.getcon_formula());	
					cabeceraserieLocal.setcon_totalizar(cabeceraserie.getcon_totalizar());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cabeceraserie.getIsDeleted()) {
				if(!existe) {
					cabeceraseries.add(cabeceraserie);
				}
			} else {
				if(cabeceraserieEncontrado!=null && permiteQuitar)  {
					cabeceraseries.remove(cabeceraserieEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CabeceraSerie cabeceraserie,List<CabeceraSerie> cabeceraseries) throws Exception {
		try	{			
			for(CabeceraSerie cabeceraserieLocal:cabeceraseries) {
				if(cabeceraserieLocal.getId().equals(cabeceraserie.getId())) {
					cabeceraserieLocal.setIsSelected(cabeceraserie.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCabeceraSerie(List<CabeceraSerie> cabeceraseriesAux) throws Exception {
		//this.cabeceraseriesAux=cabeceraseriesAux;
		
		for(CabeceraSerie cabeceraserieAux:cabeceraseriesAux) {
			if(cabeceraserieAux.getIsChanged()) {
				cabeceraserieAux.setIsChanged(false);
			}		
			
			if(cabeceraserieAux.getIsNew()) {
				cabeceraserieAux.setIsNew(false);
			}	
			
			if(cabeceraserieAux.getIsDeleted()) {
				cabeceraserieAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCabeceraSerie(CabeceraSerie cabeceraserieAux) throws Exception {
		//this.cabeceraserieAux=cabeceraserieAux;
		
			if(cabeceraserieAux.getIsChanged()) {
				cabeceraserieAux.setIsChanged(false);
			}		
			
			if(cabeceraserieAux.getIsNew()) {
				cabeceraserieAux.setIsNew(false);
			}	
			
			if(cabeceraserieAux.getIsDeleted()) {
				cabeceraserieAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CabeceraSerie cabeceraserieAsignar,CabeceraSerie cabeceraserie) throws Exception {
		cabeceraserieAsignar.setId(cabeceraserie.getId());	
		cabeceraserieAsignar.setVersionRow(cabeceraserie.getVersionRow());	
		cabeceraserieAsignar.setid_empresa(cabeceraserie.getid_empresa());
		cabeceraserieAsignar.setempresa_descripcion(cabeceraserie.getempresa_descripcion());	
		cabeceraserieAsignar.setnombre(cabeceraserie.getnombre());	
		cabeceraserieAsignar.setformula(cabeceraserie.getformula());	
		cabeceraserieAsignar.setcon_formula(cabeceraserie.getcon_formula());	
		cabeceraserieAsignar.setcon_totalizar(cabeceraserie.getcon_totalizar());	
	}
	
	public static void inicializarCabeceraSerie(CabeceraSerie cabeceraserie) throws Exception {
		try {
				cabeceraserie.setId(0L);	
					
				cabeceraserie.setid_empresa(-1L);	
				cabeceraserie.setnombre("");	
				cabeceraserie.setformula("");	
				cabeceraserie.setcon_formula(false);	
				cabeceraserie.setcon_totalizar(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCabeceraSerie(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CabeceraSerieConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CabeceraSerieConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CabeceraSerieConstantesFunciones.LABEL_FORMULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CabeceraSerieConstantesFunciones.LABEL_CONFORMULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CabeceraSerieConstantesFunciones.LABEL_CONTOTALIZAR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCabeceraSerie(String sTipo,Row row,Workbook workbook,CabeceraSerie cabeceraserie,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cabeceraserie.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cabeceraserie.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cabeceraserie.getformula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cabeceraserie.getcon_formula()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cabeceraserie.getcon_totalizar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCabeceraSerie=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCabeceraSerie() {
		return this.sFinalQueryCabeceraSerie;
	}
	
	public void setsFinalQueryCabeceraSerie(String sFinalQueryCabeceraSerie) {
		this.sFinalQueryCabeceraSerie= sFinalQueryCabeceraSerie;
	}
	
	public Border resaltarSeleccionarCabeceraSerie=null;
	
	public Border setResaltarSeleccionarCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCabeceraSerie= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCabeceraSerie() {
		return this.resaltarSeleccionarCabeceraSerie;
	}
	
	public void setResaltarSeleccionarCabeceraSerie(Border borderResaltarSeleccionarCabeceraSerie) {
		this.resaltarSeleccionarCabeceraSerie= borderResaltarSeleccionarCabeceraSerie;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCabeceraSerie=null;
	public Boolean mostraridCabeceraSerie=true;
	public Boolean activaridCabeceraSerie=true;

	public Border resaltarid_empresaCabeceraSerie=null;
	public Boolean mostrarid_empresaCabeceraSerie=true;
	public Boolean activarid_empresaCabeceraSerie=true;
	public Boolean cargarid_empresaCabeceraSerie=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCabeceraSerie=false;//ConEventDepend=true

	public Border resaltarnombreCabeceraSerie=null;
	public Boolean mostrarnombreCabeceraSerie=true;
	public Boolean activarnombreCabeceraSerie=true;

	public Border resaltarformulaCabeceraSerie=null;
	public Boolean mostrarformulaCabeceraSerie=true;
	public Boolean activarformulaCabeceraSerie=true;

	public Border resaltarcon_formulaCabeceraSerie=null;
	public Boolean mostrarcon_formulaCabeceraSerie=true;
	public Boolean activarcon_formulaCabeceraSerie=true;

	public Border resaltarcon_totalizarCabeceraSerie=null;
	public Boolean mostrarcon_totalizarCabeceraSerie=true;
	public Boolean activarcon_totalizarCabeceraSerie=true;

	
	

	public Border setResaltaridCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltaridCabeceraSerie= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCabeceraSerie() {
		return this.resaltaridCabeceraSerie;
	}

	public void setResaltaridCabeceraSerie(Border borderResaltar) {
		this.resaltaridCabeceraSerie= borderResaltar;
	}

	public Boolean getMostraridCabeceraSerie() {
		return this.mostraridCabeceraSerie;
	}

	public void setMostraridCabeceraSerie(Boolean mostraridCabeceraSerie) {
		this.mostraridCabeceraSerie= mostraridCabeceraSerie;
	}

	public Boolean getActivaridCabeceraSerie() {
		return this.activaridCabeceraSerie;
	}

	public void setActivaridCabeceraSerie(Boolean activaridCabeceraSerie) {
		this.activaridCabeceraSerie= activaridCabeceraSerie;
	}

	public Border setResaltarid_empresaCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltarid_empresaCabeceraSerie= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCabeceraSerie() {
		return this.resaltarid_empresaCabeceraSerie;
	}

	public void setResaltarid_empresaCabeceraSerie(Border borderResaltar) {
		this.resaltarid_empresaCabeceraSerie= borderResaltar;
	}

	public Boolean getMostrarid_empresaCabeceraSerie() {
		return this.mostrarid_empresaCabeceraSerie;
	}

	public void setMostrarid_empresaCabeceraSerie(Boolean mostrarid_empresaCabeceraSerie) {
		this.mostrarid_empresaCabeceraSerie= mostrarid_empresaCabeceraSerie;
	}

	public Boolean getActivarid_empresaCabeceraSerie() {
		return this.activarid_empresaCabeceraSerie;
	}

	public void setActivarid_empresaCabeceraSerie(Boolean activarid_empresaCabeceraSerie) {
		this.activarid_empresaCabeceraSerie= activarid_empresaCabeceraSerie;
	}

	public Boolean getCargarid_empresaCabeceraSerie() {
		return this.cargarid_empresaCabeceraSerie;
	}

	public void setCargarid_empresaCabeceraSerie(Boolean cargarid_empresaCabeceraSerie) {
		this.cargarid_empresaCabeceraSerie= cargarid_empresaCabeceraSerie;
	}

	public Border setResaltarnombreCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltarnombreCabeceraSerie= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCabeceraSerie() {
		return this.resaltarnombreCabeceraSerie;
	}

	public void setResaltarnombreCabeceraSerie(Border borderResaltar) {
		this.resaltarnombreCabeceraSerie= borderResaltar;
	}

	public Boolean getMostrarnombreCabeceraSerie() {
		return this.mostrarnombreCabeceraSerie;
	}

	public void setMostrarnombreCabeceraSerie(Boolean mostrarnombreCabeceraSerie) {
		this.mostrarnombreCabeceraSerie= mostrarnombreCabeceraSerie;
	}

	public Boolean getActivarnombreCabeceraSerie() {
		return this.activarnombreCabeceraSerie;
	}

	public void setActivarnombreCabeceraSerie(Boolean activarnombreCabeceraSerie) {
		this.activarnombreCabeceraSerie= activarnombreCabeceraSerie;
	}

	public Border setResaltarformulaCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltarformulaCabeceraSerie= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarformulaCabeceraSerie() {
		return this.resaltarformulaCabeceraSerie;
	}

	public void setResaltarformulaCabeceraSerie(Border borderResaltar) {
		this.resaltarformulaCabeceraSerie= borderResaltar;
	}

	public Boolean getMostrarformulaCabeceraSerie() {
		return this.mostrarformulaCabeceraSerie;
	}

	public void setMostrarformulaCabeceraSerie(Boolean mostrarformulaCabeceraSerie) {
		this.mostrarformulaCabeceraSerie= mostrarformulaCabeceraSerie;
	}

	public Boolean getActivarformulaCabeceraSerie() {
		return this.activarformulaCabeceraSerie;
	}

	public void setActivarformulaCabeceraSerie(Boolean activarformulaCabeceraSerie) {
		this.activarformulaCabeceraSerie= activarformulaCabeceraSerie;
	}

	public Border setResaltarcon_formulaCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltarcon_formulaCabeceraSerie= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_formulaCabeceraSerie() {
		return this.resaltarcon_formulaCabeceraSerie;
	}

	public void setResaltarcon_formulaCabeceraSerie(Border borderResaltar) {
		this.resaltarcon_formulaCabeceraSerie= borderResaltar;
	}

	public Boolean getMostrarcon_formulaCabeceraSerie() {
		return this.mostrarcon_formulaCabeceraSerie;
	}

	public void setMostrarcon_formulaCabeceraSerie(Boolean mostrarcon_formulaCabeceraSerie) {
		this.mostrarcon_formulaCabeceraSerie= mostrarcon_formulaCabeceraSerie;
	}

	public Boolean getActivarcon_formulaCabeceraSerie() {
		return this.activarcon_formulaCabeceraSerie;
	}

	public void setActivarcon_formulaCabeceraSerie(Boolean activarcon_formulaCabeceraSerie) {
		this.activarcon_formulaCabeceraSerie= activarcon_formulaCabeceraSerie;
	}

	public Border setResaltarcon_totalizarCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cabeceraserieBeanSwingJInternalFrame.jTtoolBarCabeceraSerie.setBorder(borderResaltar);
		
		this.resaltarcon_totalizarCabeceraSerie= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_totalizarCabeceraSerie() {
		return this.resaltarcon_totalizarCabeceraSerie;
	}

	public void setResaltarcon_totalizarCabeceraSerie(Border borderResaltar) {
		this.resaltarcon_totalizarCabeceraSerie= borderResaltar;
	}

	public Boolean getMostrarcon_totalizarCabeceraSerie() {
		return this.mostrarcon_totalizarCabeceraSerie;
	}

	public void setMostrarcon_totalizarCabeceraSerie(Boolean mostrarcon_totalizarCabeceraSerie) {
		this.mostrarcon_totalizarCabeceraSerie= mostrarcon_totalizarCabeceraSerie;
	}

	public Boolean getActivarcon_totalizarCabeceraSerie() {
		return this.activarcon_totalizarCabeceraSerie;
	}

	public void setActivarcon_totalizarCabeceraSerie(Boolean activarcon_totalizarCabeceraSerie) {
		this.activarcon_totalizarCabeceraSerie= activarcon_totalizarCabeceraSerie;
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
		
		
		this.setMostraridCabeceraSerie(esInicial);
		this.setMostrarid_empresaCabeceraSerie(esInicial);
		this.setMostrarnombreCabeceraSerie(esInicial);
		this.setMostrarformulaCabeceraSerie(esInicial);
		this.setMostrarcon_formulaCabeceraSerie(esInicial);
		this.setMostrarcon_totalizarCabeceraSerie(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.ID)) {
				this.setMostraridCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.FORMULA)) {
				this.setMostrarformulaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.CONFORMULA)) {
				this.setMostrarcon_formulaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.CONTOTALIZAR)) {
				this.setMostrarcon_totalizarCabeceraSerie(esAsigna);
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
		
		
		this.setActivaridCabeceraSerie(esInicial);
		this.setActivarid_empresaCabeceraSerie(esInicial);
		this.setActivarnombreCabeceraSerie(esInicial);
		this.setActivarformulaCabeceraSerie(esInicial);
		this.setActivarcon_formulaCabeceraSerie(esInicial);
		this.setActivarcon_totalizarCabeceraSerie(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.ID)) {
				this.setActivaridCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.FORMULA)) {
				this.setActivarformulaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.CONFORMULA)) {
				this.setActivarcon_formulaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.CONTOTALIZAR)) {
				this.setActivarcon_totalizarCabeceraSerie(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCabeceraSerie(esInicial);
		this.setResaltarid_empresaCabeceraSerie(esInicial);
		this.setResaltarnombreCabeceraSerie(esInicial);
		this.setResaltarformulaCabeceraSerie(esInicial);
		this.setResaltarcon_formulaCabeceraSerie(esInicial);
		this.setResaltarcon_totalizarCabeceraSerie(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.ID)) {
				this.setResaltaridCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.FORMULA)) {
				this.setResaltarformulaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.CONFORMULA)) {
				this.setResaltarcon_formulaCabeceraSerie(esAsigna);
				continue;
			}

			if(campo.clase.equals(CabeceraSerieConstantesFunciones.CONTOTALIZAR)) {
				this.setResaltarcon_totalizarCabeceraSerie(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreCabeceraSerie=true;

	public Boolean getMostrarBusquedaPorNombreCabeceraSerie() {
		return this.mostrarBusquedaPorNombreCabeceraSerie;
	}

	public void setMostrarBusquedaPorNombreCabeceraSerie(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCabeceraSerie= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCabeceraSerie=true;

	public Boolean getMostrarFK_IdEmpresaCabeceraSerie() {
		return this.mostrarFK_IdEmpresaCabeceraSerie;
	}

	public void setMostrarFK_IdEmpresaCabeceraSerie(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCabeceraSerie= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreCabeceraSerie=true;

	public Boolean getActivarBusquedaPorNombreCabeceraSerie() {
		return this.activarBusquedaPorNombreCabeceraSerie;
	}

	public void setActivarBusquedaPorNombreCabeceraSerie(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCabeceraSerie= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCabeceraSerie=true;

	public Boolean getActivarFK_IdEmpresaCabeceraSerie() {
		return this.activarFK_IdEmpresaCabeceraSerie;
	}

	public void setActivarFK_IdEmpresaCabeceraSerie(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCabeceraSerie= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreCabeceraSerie=null;

	public Border getResaltarBusquedaPorNombreCabeceraSerie() {
		return this.resaltarBusquedaPorNombreCabeceraSerie;
	}

	public void setResaltarBusquedaPorNombreCabeceraSerie(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCabeceraSerie= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCabeceraSerie= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCabeceraSerie=null;

	public Border getResaltarFK_IdEmpresaCabeceraSerie() {
		return this.resaltarFK_IdEmpresaCabeceraSerie;
	}

	public void setResaltarFK_IdEmpresaCabeceraSerie(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCabeceraSerie= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCabeceraSerie(ParametroGeneralUsuario parametroGeneralUsuario/*CabeceraSerieBeanSwingJInternalFrame cabeceraserieBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCabeceraSerie= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}