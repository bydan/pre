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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.SistemaConstantesFunciones;
import com.bydan.erp.seguridad.util.SistemaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SistemaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SistemaConstantesFunciones extends SistemaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Sistema";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Sistema"+SistemaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SistemaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SistemaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SistemaConstantesFunciones.SCHEMA+"_"+SistemaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SistemaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SistemaConstantesFunciones.SCHEMA+"_"+SistemaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SistemaConstantesFunciones.SCHEMA+"_"+SistemaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SistemaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SistemaConstantesFunciones.SCHEMA+"_"+SistemaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SistemaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SistemaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SistemaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SistemaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SistemaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SistemaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SistemaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SistemaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SistemaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SistemaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sistemas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sistema";
	public static final String SCLASSWEBTITULO_LOWER="Sistema";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Sistema";
	public static final String OBJECTNAME="sistema";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="sistema";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sistema from "+SistemaConstantesFunciones.SPERSISTENCENAME+" sistema";
	public static String QUERYSELECTNATIVE="select "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".id,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".version_row,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".codigo,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".nombre_principal,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".nombre_secundario,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".estado from "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME;//+" as "+SistemaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected SistemaConstantesFuncionesAdditional sistemaConstantesFuncionesAdditional=null;
	
	public SistemaConstantesFuncionesAdditional getSistemaConstantesFuncionesAdditional() {
		return this.sistemaConstantesFuncionesAdditional;
	}
	
	public void setSistemaConstantesFuncionesAdditional(SistemaConstantesFuncionesAdditional sistemaConstantesFuncionesAdditional) {
		try {
			this.sistemaConstantesFuncionesAdditional=sistemaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBREPRINCIPAL= "nombre_principal";
    public static final String NOMBRESECUNDARIO= "nombre_secundario";
    public static final String ESTADO= "estado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBREPRINCIPAL= "Nombre Principal";
		public static final String LABEL_NOMBREPRINCIPAL_LOWER= "Nombre Principal";
    	public static final String LABEL_NOMBRESECUNDARIO= "Nombre Secundario";
		public static final String LABEL_NOMBRESECUNDARIO_LOWER= "Nombre Secundario";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRINCIPAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRINCIPAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SECUNDARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SECUNDARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getSistemaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SistemaConstantesFunciones.CODIGO)) {sLabelColumna=SistemaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SistemaConstantesFunciones.NOMBREPRINCIPAL)) {sLabelColumna=SistemaConstantesFunciones.LABEL_NOMBREPRINCIPAL;}
		if(sNombreColumna.equals(SistemaConstantesFunciones.NOMBRESECUNDARIO)) {sLabelColumna=SistemaConstantesFunciones.LABEL_NOMBRESECUNDARIO;}
		if(sNombreColumna.equals(SistemaConstantesFunciones.ESTADO)) {sLabelColumna=SistemaConstantesFunciones.LABEL_ESTADO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getestadoDescripcion(Sistema sistema) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!sistema.getestado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestadoHtmlDescripcion(Sistema sistema) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(sistema.getId(),sistema.getestado());

		return sDescripcion;
	}	
	
	public static String getSistemaDescripcion(Sistema sistema) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sistema !=null/* && sistema.getId()!=0*/) {
			sDescripcion=sistema.getnombre_principal();//sistemasistema.getnombre_principal().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSistemaDescripcionDetallado(Sistema sistema) {
		String sDescripcion="";
			
		sDescripcion+=SistemaConstantesFunciones.ID+"=";
		sDescripcion+=sistema.getId().toString()+",";
		sDescripcion+=SistemaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sistema.getVersionRow().toString()+",";
		sDescripcion+=SistemaConstantesFunciones.CODIGO+"=";
		sDescripcion+=sistema.getcodigo()+",";
		sDescripcion+=SistemaConstantesFunciones.NOMBREPRINCIPAL+"=";
		sDescripcion+=sistema.getnombre_principal()+",";
		sDescripcion+=SistemaConstantesFunciones.NOMBRESECUNDARIO+"=";
		sDescripcion+=sistema.getnombre_secundario()+",";
		sDescripcion+=SistemaConstantesFunciones.ESTADO+"=";
		sDescripcion+=sistema.getestado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSistemaDescripcion(Sistema sistema,String sValor) throws Exception {			
		if(sistema !=null) {
			sistema.setnombre_principal(sValor);;//sistemasistema.getnombre_principal().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombrePrincipal")) {
			sNombreIndice="Tipo=  Por Nombre Principal";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("PorNombrePrincipal")) {
			sNombreIndice="Tipo=  Por Nombre Principal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombrePrincipal(String nombre_principal) {
		String sDetalleIndice=" Parametros->";
		if(nombre_principal!=null) {sDetalleIndice+=" Nombre Principal="+nombre_principal;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombrePrincipal(String nombre_principal) {
		String sDetalleIndice=" Parametros->";
		if(nombre_principal!=null) {sDetalleIndice+=" Nombre Principal="+nombre_principal;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSistema(Sistema sistema,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sistema.setcodigo(sistema.getcodigo().trim());
		sistema.setnombre_principal(sistema.getnombre_principal().trim());
		sistema.setnombre_secundario(sistema.getnombre_secundario().trim());
	}
	
	public static void quitarEspaciosSistemas(List<Sistema> sistemas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Sistema sistema: sistemas) {
			sistema.setcodigo(sistema.getcodigo().trim());
			sistema.setnombre_principal(sistema.getnombre_principal().trim());
			sistema.setnombre_secundario(sistema.getnombre_secundario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSistema(Sistema sistema,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sistema.getConCambioAuxiliar()) {
			sistema.setIsDeleted(sistema.getIsDeletedAuxiliar());	
			sistema.setIsNew(sistema.getIsNewAuxiliar());	
			sistema.setIsChanged(sistema.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sistema.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sistema.setIsDeletedAuxiliar(false);	
			sistema.setIsNewAuxiliar(false);	
			sistema.setIsChangedAuxiliar(false);
			
			sistema.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSistemas(List<Sistema> sistemas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Sistema sistema : sistemas) {
			if(conAsignarBase && sistema.getConCambioAuxiliar()) {
				sistema.setIsDeleted(sistema.getIsDeletedAuxiliar());	
				sistema.setIsNew(sistema.getIsNewAuxiliar());	
				sistema.setIsChanged(sistema.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sistema.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sistema.setIsDeletedAuxiliar(false);	
				sistema.setIsNewAuxiliar(false);	
				sistema.setIsChangedAuxiliar(false);
				
				sistema.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSistema(Sistema sistema,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSistemas(List<Sistema> sistemas,Boolean conEnteros) throws Exception  {
		
		for(Sistema sistema: sistemas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSistema(List<Sistema> sistemas,Sistema sistemaAux) throws Exception  {
		SistemaConstantesFunciones.InicializarValoresSistema(sistemaAux,true);
		
		for(Sistema sistema: sistemas) {
			if(sistema.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSistema(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SistemaConstantesFunciones.getArrayColumnasGlobalesSistema(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSistema(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSistema(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Sistema> sistemas,Sistema sistema,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Sistema sistemaAux: sistemas) {
			if(sistemaAux!=null && sistema!=null) {
				if((sistemaAux.getId()==null && sistema.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sistemaAux.getId()!=null && sistema.getId()!=null){
					if(sistemaAux.getId().equals(sistema.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSistema(List<Sistema> sistemas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Sistema sistema: sistemas) {			
			if(sistema.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSistema() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SistemaConstantesFunciones.LABEL_ID, SistemaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SistemaConstantesFunciones.LABEL_VERSIONROW, SistemaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SistemaConstantesFunciones.LABEL_CODIGO, SistemaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SistemaConstantesFunciones.LABEL_NOMBREPRINCIPAL, SistemaConstantesFunciones.NOMBREPRINCIPAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SistemaConstantesFunciones.LABEL_NOMBRESECUNDARIO, SistemaConstantesFunciones.NOMBRESECUNDARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SistemaConstantesFunciones.LABEL_ESTADO, SistemaConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSistema() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SistemaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SistemaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SistemaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SistemaConstantesFunciones.NOMBREPRINCIPAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SistemaConstantesFunciones.NOMBRESECUNDARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SistemaConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSistema() throws Exception  {
		return SistemaConstantesFunciones.getTiposSeleccionarSistema(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSistema(Boolean conFk) throws Exception  {
		return SistemaConstantesFunciones.getTiposSeleccionarSistema(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSistema(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SistemaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SistemaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SistemaConstantesFunciones.LABEL_NOMBREPRINCIPAL);
			reporte.setsDescripcion(SistemaConstantesFunciones.LABEL_NOMBREPRINCIPAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SistemaConstantesFunciones.LABEL_NOMBRESECUNDARIO);
			reporte.setsDescripcion(SistemaConstantesFunciones.LABEL_NOMBRESECUNDARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SistemaConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(SistemaConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSistema(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSistema(Sistema sistemaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesSistema(List<Sistema> sistemasTemp) throws Exception {
		for(Sistema sistemaAux:sistemasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSistema(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSistema(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSistema(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SistemaConstantesFunciones.getClassesRelationshipsOfSistema(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSistema(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Perfil.class));
				classes.add(new Classe(PerfilOpcion.class));
				classes.add(new Classe(UsuarioOpcion.class));
				classes.add(new Classe(Opcion.class));
				classes.add(new Classe(Paquete.class));
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Perfil.class)) {
						classes.add(new Classe(Perfil.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PerfilOpcion.class)) {
						classes.add(new Classe(PerfilOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(UsuarioOpcion.class)) {
						classes.add(new Classe(UsuarioOpcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Opcion.class)) {
						classes.add(new Classe(Opcion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Paquete.class)) {
						classes.add(new Classe(Paquete.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSistema(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SistemaConstantesFunciones.getClassesRelationshipsFromStringsOfSistema(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSistema(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(Paquete.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Paquete.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Perfil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Perfil.class)); continue;
					}

					if(PerfilOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PerfilOpcion.class)); continue;
					}

					if(UsuarioOpcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UsuarioOpcion.class)); continue;
					}

					if(Opcion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Opcion.class)); continue;
					}

					if(Paquete.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Paquete.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	public static void actualizarLista(Sistema sistema,List<Sistema> sistemas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Sistema sistemaEncontrado=null;
			
			for(Sistema sistemaLocal:sistemas) {
				if(sistemaLocal.getId().equals(sistema.getId())) {
					sistemaEncontrado=sistemaLocal;
					
					sistemaLocal.setIsChanged(sistema.getIsChanged());
					sistemaLocal.setIsNew(sistema.getIsNew());
					sistemaLocal.setIsDeleted(sistema.getIsDeleted());
					
					sistemaLocal.setGeneralEntityOriginal(sistema.getGeneralEntityOriginal());
					
					sistemaLocal.setId(sistema.getId());	
					sistemaLocal.setVersionRow(sistema.getVersionRow());	
					sistemaLocal.setcodigo(sistema.getcodigo());	
					sistemaLocal.setnombre_principal(sistema.getnombre_principal());	
					sistemaLocal.setnombre_secundario(sistema.getnombre_secundario());	
					sistemaLocal.setestado(sistema.getestado());	
					
					
					sistemaLocal.setPerfils(sistema.getPerfils());
					sistemaLocal.setOpcions(sistema.getOpcions());
					sistemaLocal.setPaquetes(sistema.getPaquetes());
					sistemaLocal.setModulos(sistema.getModulos());
					
					existe=true;
					break;
				}
			}
			
			if(!sistema.getIsDeleted()) {
				if(!existe) {
					sistemas.add(sistema);
				}
			} else {
				if(sistemaEncontrado!=null && permiteQuitar)  {
					sistemas.remove(sistemaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Sistema sistema,List<Sistema> sistemas) throws Exception {
		try	{			
			for(Sistema sistemaLocal:sistemas) {
				if(sistemaLocal.getId().equals(sistema.getId())) {
					sistemaLocal.setIsSelected(sistema.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSistema(List<Sistema> sistemasAux) throws Exception {
		//this.sistemasAux=sistemasAux;
		
		for(Sistema sistemaAux:sistemasAux) {
			if(sistemaAux.getIsChanged()) {
				sistemaAux.setIsChanged(false);
			}		
			
			if(sistemaAux.getIsNew()) {
				sistemaAux.setIsNew(false);
			}	
			
			if(sistemaAux.getIsDeleted()) {
				sistemaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSistema(Sistema sistemaAux) throws Exception {
		//this.sistemaAux=sistemaAux;
		
			if(sistemaAux.getIsChanged()) {
				sistemaAux.setIsChanged(false);
			}		
			
			if(sistemaAux.getIsNew()) {
				sistemaAux.setIsNew(false);
			}	
			
			if(sistemaAux.getIsDeleted()) {
				sistemaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Sistema sistemaAsignar,Sistema sistema) throws Exception {
		sistemaAsignar.setId(sistema.getId());	
		sistemaAsignar.setVersionRow(sistema.getVersionRow());	
		sistemaAsignar.setcodigo(sistema.getcodigo());	
		sistemaAsignar.setnombre_principal(sistema.getnombre_principal());	
		sistemaAsignar.setnombre_secundario(sistema.getnombre_secundario());	
		sistemaAsignar.setestado(sistema.getestado());	
	}
	
	public static void inicializarSistema(Sistema sistema) throws Exception {
		try {
				sistema.setId(0L);	
					
				sistema.setcodigo("");	
				sistema.setnombre_principal("");	
				sistema.setnombre_secundario("");	
				sistema.setestado(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSistema(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SistemaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SistemaConstantesFunciones.LABEL_NOMBREPRINCIPAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SistemaConstantesFunciones.LABEL_NOMBRESECUNDARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SistemaConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSistema(String sTipo,Row row,Workbook workbook,Sistema sistema,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sistema.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sistema.getnombre_principal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sistema.getnombre_secundario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(sistema.getestado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySistema=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySistema() {
		return this.sFinalQuerySistema;
	}
	
	public void setsFinalQuerySistema(String sFinalQuerySistema) {
		this.sFinalQuerySistema= sFinalQuerySistema;
	}
	
	public Border resaltarSeleccionarSistema=null;
	
	public Border setResaltarSeleccionarSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSistema= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSistema() {
		return this.resaltarSeleccionarSistema;
	}
	
	public void setResaltarSeleccionarSistema(Border borderResaltarSeleccionarSistema) {
		this.resaltarSeleccionarSistema= borderResaltarSeleccionarSistema;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSistema=null;
	public Boolean mostraridSistema=true;
	public Boolean activaridSistema=true;

	public Border resaltarcodigoSistema=null;
	public Boolean mostrarcodigoSistema=true;
	public Boolean activarcodigoSistema=true;

	public Border resaltarnombre_principalSistema=null;
	public Boolean mostrarnombre_principalSistema=true;
	public Boolean activarnombre_principalSistema=true;

	public Border resaltarnombre_secundarioSistema=null;
	public Boolean mostrarnombre_secundarioSistema=true;
	public Boolean activarnombre_secundarioSistema=true;

	public Border resaltarestadoSistema=null;
	public Boolean mostrarestadoSistema=true;
	public Boolean activarestadoSistema=true;

	
	

	public Border setResaltaridSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltar);
		
		this.resaltaridSistema= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSistema() {
		return this.resaltaridSistema;
	}

	public void setResaltaridSistema(Border borderResaltar) {
		this.resaltaridSistema= borderResaltar;
	}

	public Boolean getMostraridSistema() {
		return this.mostraridSistema;
	}

	public void setMostraridSistema(Boolean mostraridSistema) {
		this.mostraridSistema= mostraridSistema;
	}

	public Boolean getActivaridSistema() {
		return this.activaridSistema;
	}

	public void setActivaridSistema(Boolean activaridSistema) {
		this.activaridSistema= activaridSistema;
	}

	public Border setResaltarcodigoSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltar);
		
		this.resaltarcodigoSistema= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSistema() {
		return this.resaltarcodigoSistema;
	}

	public void setResaltarcodigoSistema(Border borderResaltar) {
		this.resaltarcodigoSistema= borderResaltar;
	}

	public Boolean getMostrarcodigoSistema() {
		return this.mostrarcodigoSistema;
	}

	public void setMostrarcodigoSistema(Boolean mostrarcodigoSistema) {
		this.mostrarcodigoSistema= mostrarcodigoSistema;
	}

	public Boolean getActivarcodigoSistema() {
		return this.activarcodigoSistema;
	}

	public void setActivarcodigoSistema(Boolean activarcodigoSistema) {
		this.activarcodigoSistema= activarcodigoSistema;
	}

	public Border setResaltarnombre_principalSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltar);
		
		this.resaltarnombre_principalSistema= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_principalSistema() {
		return this.resaltarnombre_principalSistema;
	}

	public void setResaltarnombre_principalSistema(Border borderResaltar) {
		this.resaltarnombre_principalSistema= borderResaltar;
	}

	public Boolean getMostrarnombre_principalSistema() {
		return this.mostrarnombre_principalSistema;
	}

	public void setMostrarnombre_principalSistema(Boolean mostrarnombre_principalSistema) {
		this.mostrarnombre_principalSistema= mostrarnombre_principalSistema;
	}

	public Boolean getActivarnombre_principalSistema() {
		return this.activarnombre_principalSistema;
	}

	public void setActivarnombre_principalSistema(Boolean activarnombre_principalSistema) {
		this.activarnombre_principalSistema= activarnombre_principalSistema;
	}

	public Border setResaltarnombre_secundarioSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltar);
		
		this.resaltarnombre_secundarioSistema= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_secundarioSistema() {
		return this.resaltarnombre_secundarioSistema;
	}

	public void setResaltarnombre_secundarioSistema(Border borderResaltar) {
		this.resaltarnombre_secundarioSistema= borderResaltar;
	}

	public Boolean getMostrarnombre_secundarioSistema() {
		return this.mostrarnombre_secundarioSistema;
	}

	public void setMostrarnombre_secundarioSistema(Boolean mostrarnombre_secundarioSistema) {
		this.mostrarnombre_secundarioSistema= mostrarnombre_secundarioSistema;
	}

	public Boolean getActivarnombre_secundarioSistema() {
		return this.activarnombre_secundarioSistema;
	}

	public void setActivarnombre_secundarioSistema(Boolean activarnombre_secundarioSistema) {
		this.activarnombre_secundarioSistema= activarnombre_secundarioSistema;
	}

	public Border setResaltarestadoSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltar);
		
		this.resaltarestadoSistema= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoSistema() {
		return this.resaltarestadoSistema;
	}

	public void setResaltarestadoSistema(Border borderResaltar) {
		this.resaltarestadoSistema= borderResaltar;
	}

	public Boolean getMostrarestadoSistema() {
		return this.mostrarestadoSistema;
	}

	public void setMostrarestadoSistema(Boolean mostrarestadoSistema) {
		this.mostrarestadoSistema= mostrarestadoSistema;
	}

	public Boolean getActivarestadoSistema() {
		return this.activarestadoSistema;
	}

	public void setActivarestadoSistema(Boolean activarestadoSistema) {
		this.activarestadoSistema= activarestadoSistema;
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
		
		
		this.setMostraridSistema(esInicial);
		this.setMostrarcodigoSistema(esInicial);
		this.setMostrarnombre_principalSistema(esInicial);
		this.setMostrarnombre_secundarioSistema(esInicial);
		this.setMostrarestadoSistema(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SistemaConstantesFunciones.ID)) {
				this.setMostraridSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.NOMBREPRINCIPAL)) {
				this.setMostrarnombre_principalSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.NOMBRESECUNDARIO)) {
				this.setMostrarnombre_secundarioSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.ESTADO)) {
				this.setMostrarestadoSistema(esAsigna);
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
		
		
		this.setActivaridSistema(esInicial);
		this.setActivarcodigoSistema(esInicial);
		this.setActivarnombre_principalSistema(esInicial);
		this.setActivarnombre_secundarioSistema(esInicial);
		this.setActivarestadoSistema(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SistemaConstantesFunciones.ID)) {
				this.setActivaridSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.NOMBREPRINCIPAL)) {
				this.setActivarnombre_principalSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.NOMBRESECUNDARIO)) {
				this.setActivarnombre_secundarioSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.ESTADO)) {
				this.setActivarestadoSistema(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSistema(esInicial);
		this.setResaltarcodigoSistema(esInicial);
		this.setResaltarnombre_principalSistema(esInicial);
		this.setResaltarnombre_secundarioSistema(esInicial);
		this.setResaltarestadoSistema(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SistemaConstantesFunciones.ID)) {
				this.setResaltaridSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.NOMBREPRINCIPAL)) {
				this.setResaltarnombre_principalSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.NOMBRESECUNDARIO)) {
				this.setResaltarnombre_secundarioSistema(esAsigna);
				continue;
			}

			if(campo.clase.equals(SistemaConstantesFunciones.ESTADO)) {
				this.setResaltarestadoSistema(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPerfilSistema=null;

	public Border getResaltarPerfilSistema() {
		return this.resaltarPerfilSistema;
	}

	public void setResaltarPerfilSistema(Border borderResaltarPerfil) {
		if(borderResaltarPerfil!=null) {
			this.resaltarPerfilSistema= borderResaltarPerfil;
		}
	}

	public Border setResaltarPerfilSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltarPerfil=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltarPerfil);
			
		this.resaltarPerfilSistema= borderResaltarPerfil;

		 return borderResaltarPerfil;
	}



	public Boolean mostrarPerfilSistema=true;

	public Boolean getMostrarPerfilSistema() {
		return this.mostrarPerfilSistema;
	}

	public void setMostrarPerfilSistema(Boolean visibilidadResaltarPerfil) {
		this.mostrarPerfilSistema= visibilidadResaltarPerfil;
	}



	public Boolean activarPerfilSistema=true;

	public Boolean gethabilitarResaltarPerfilSistema() {
		return this.activarPerfilSistema;
	}

	public void setActivarPerfilSistema(Boolean habilitarResaltarPerfil) {
		this.activarPerfilSistema= habilitarResaltarPerfil;
	}


	public Border resaltarOpcionSistema=null;

	public Border getResaltarOpcionSistema() {
		return this.resaltarOpcionSistema;
	}

	public void setResaltarOpcionSistema(Border borderResaltarOpcion) {
		if(borderResaltarOpcion!=null) {
			this.resaltarOpcionSistema= borderResaltarOpcion;
		}
	}

	public Border setResaltarOpcionSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltarOpcion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltarOpcion);
			
		this.resaltarOpcionSistema= borderResaltarOpcion;

		 return borderResaltarOpcion;
	}



	public Boolean mostrarOpcionSistema=true;

	public Boolean getMostrarOpcionSistema() {
		return this.mostrarOpcionSistema;
	}

	public void setMostrarOpcionSistema(Boolean visibilidadResaltarOpcion) {
		this.mostrarOpcionSistema= visibilidadResaltarOpcion;
	}



	public Boolean activarOpcionSistema=true;

	public Boolean gethabilitarResaltarOpcionSistema() {
		return this.activarOpcionSistema;
	}

	public void setActivarOpcionSistema(Boolean habilitarResaltarOpcion) {
		this.activarOpcionSistema= habilitarResaltarOpcion;
	}


	public Border resaltarPaqueteSistema=null;

	public Border getResaltarPaqueteSistema() {
		return this.resaltarPaqueteSistema;
	}

	public void setResaltarPaqueteSistema(Border borderResaltarPaquete) {
		if(borderResaltarPaquete!=null) {
			this.resaltarPaqueteSistema= borderResaltarPaquete;
		}
	}

	public Border setResaltarPaqueteSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltarPaquete=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltarPaquete);
			
		this.resaltarPaqueteSistema= borderResaltarPaquete;

		 return borderResaltarPaquete;
	}



	public Boolean mostrarPaqueteSistema=true;

	public Boolean getMostrarPaqueteSistema() {
		return this.mostrarPaqueteSistema;
	}

	public void setMostrarPaqueteSistema(Boolean visibilidadResaltarPaquete) {
		this.mostrarPaqueteSistema= visibilidadResaltarPaquete;
	}



	public Boolean activarPaqueteSistema=true;

	public Boolean gethabilitarResaltarPaqueteSistema() {
		return this.activarPaqueteSistema;
	}

	public void setActivarPaqueteSistema(Boolean habilitarResaltarPaquete) {
		this.activarPaqueteSistema= habilitarResaltarPaquete;
	}


	public Border resaltarModuloSistema=null;

	public Border getResaltarModuloSistema() {
		return this.resaltarModuloSistema;
	}

	public void setResaltarModuloSistema(Border borderResaltarModulo) {
		if(borderResaltarModulo!=null) {
			this.resaltarModuloSistema= borderResaltarModulo;
		}
	}

	public Border setResaltarModuloSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltarModulo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//sistemaBeanSwingJInternalFrame.jTtoolBarSistema.setBorder(borderResaltarModulo);
			
		this.resaltarModuloSistema= borderResaltarModulo;

		 return borderResaltarModulo;
	}



	public Boolean mostrarModuloSistema=true;

	public Boolean getMostrarModuloSistema() {
		return this.mostrarModuloSistema;
	}

	public void setMostrarModuloSistema(Boolean visibilidadResaltarModulo) {
		this.mostrarModuloSistema= visibilidadResaltarModulo;
	}



	public Boolean activarModuloSistema=true;

	public Boolean gethabilitarResaltarModuloSistema() {
		return this.activarModuloSistema;
	}

	public void setActivarModuloSistema(Boolean habilitarResaltarModulo) {
		this.activarModuloSistema= habilitarResaltarModulo;
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

		this.setMostrarPerfilSistema(esInicial);
		this.setMostrarOpcionSistema(esInicial);
		this.setMostrarPaqueteSistema(esInicial);
		this.setMostrarModuloSistema(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Perfil.class)) {
				this.setMostrarPerfilSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setMostrarOpcionSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Paquete.class)) {
				this.setMostrarPaqueteSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Modulo.class)) {
				this.setMostrarModuloSistema(esAsigna);
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

		this.setActivarPerfilSistema(esInicial);
		this.setActivarOpcionSistema(esInicial);
		this.setActivarPaqueteSistema(esInicial);
		this.setActivarModuloSistema(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Perfil.class)) {
				this.setActivarPerfilSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setActivarOpcionSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Paquete.class)) {
				this.setActivarPaqueteSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Modulo.class)) {
				this.setActivarModuloSistema(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPerfilSistema(esInicial);
		this.setResaltarOpcionSistema(esInicial);
		this.setResaltarPaqueteSistema(esInicial);
		this.setResaltarModuloSistema(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Perfil.class)) {
				this.setResaltarPerfilSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Opcion.class)) {
				this.setResaltarOpcionSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Paquete.class)) {
				this.setResaltarPaqueteSistema(esAsigna);
				continue;
			}

			if(clase.clas.equals(Modulo.class)) {
				this.setResaltarModuloSistema(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoSistema=true;

	public Boolean getMostrarBusquedaPorCodigoSistema() {
		return this.mostrarBusquedaPorCodigoSistema;
	}

	public void setMostrarBusquedaPorCodigoSistema(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoSistema= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePrincipalSistema=true;

	public Boolean getMostrarBusquedaPorNombrePrincipalSistema() {
		return this.mostrarBusquedaPorNombrePrincipalSistema;
	}

	public void setMostrarBusquedaPorNombrePrincipalSistema(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePrincipalSistema= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoSistema=true;

	public Boolean getActivarBusquedaPorCodigoSistema() {
		return this.activarBusquedaPorCodigoSistema;
	}

	public void setActivarBusquedaPorCodigoSistema(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoSistema= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePrincipalSistema=true;

	public Boolean getActivarBusquedaPorNombrePrincipalSistema() {
		return this.activarBusquedaPorNombrePrincipalSistema;
	}

	public void setActivarBusquedaPorNombrePrincipalSistema(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePrincipalSistema= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoSistema=null;

	public Border getResaltarBusquedaPorCodigoSistema() {
		return this.resaltarBusquedaPorCodigoSistema;
	}

	public void setResaltarBusquedaPorCodigoSistema(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoSistema= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoSistema= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePrincipalSistema=null;

	public Border getResaltarBusquedaPorNombrePrincipalSistema() {
		return this.resaltarBusquedaPorNombrePrincipalSistema;
	}

	public void setResaltarBusquedaPorNombrePrincipalSistema(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePrincipalSistema= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePrincipalSistema(ParametroGeneralUsuario parametroGeneralUsuario/*SistemaBeanSwingJInternalFrame sistemaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePrincipalSistema= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}