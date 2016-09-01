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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.ConyugeConstantesFunciones;
import com.bydan.erp.cartera.util.ConyugeParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ConyugeParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConyugeConstantesFunciones extends ConyugeConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Conyuge";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Conyuge"+ConyugeConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConyugeHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConyugeHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConyugeConstantesFunciones.SCHEMA+"_"+ConyugeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConyugeHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConyugeConstantesFunciones.SCHEMA+"_"+ConyugeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConyugeConstantesFunciones.SCHEMA+"_"+ConyugeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConyugeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConyugeConstantesFunciones.SCHEMA+"_"+ConyugeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConyugeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConyugeHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConyugeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConyugeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConyugeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConyugeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConyugeConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConyugeConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConyugeConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConyugeConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Conyuges";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Conyuge";
	public static final String SCLASSWEBTITULO_LOWER="Conyuge";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Conyuge";
	public static final String OBJECTNAME="conyuge";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="conyuge";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select conyuge from "+ConyugeConstantesFunciones.SPERSISTENCENAME+" conyuge";
	public static String QUERYSELECTNATIVE="select "+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".id,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".version_row,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".idvaloridentificacion,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".identificacion,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".apellidopaterno,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".apellidomaterno,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".primernombre,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".segundonombre,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".nombrecorto,"+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME+".esactivo from "+ConyugeConstantesFunciones.SCHEMA+"."+ConyugeConstantesFunciones.TABLENAME;//+" as "+ConyugeConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ConyugeConstantesFuncionesAdditional conyugeConstantesFuncionesAdditional=null;
	
	public ConyugeConstantesFuncionesAdditional getConyugeConstantesFuncionesAdditional() {
		return this.conyugeConstantesFuncionesAdditional;
	}
	
	public void setConyugeConstantesFuncionesAdditional(ConyugeConstantesFuncionesAdditional conyugeConstantesFuncionesAdditional) {
		try {
			this.conyugeConstantesFuncionesAdditional=conyugeConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOIDENTIFICACION= "idvaloridentificacion";
    public static final String IDENTIFICACION= "identificacion";
    public static final String APELLIDOPATERNO= "apellidopaterno";
    public static final String APELLIDOMATERNO= "apellidomaterno";
    public static final String PRIMERNOMBRE= "primernombre";
    public static final String SEGUNDONOMBRE= "segundonombre";
    public static final String NOMBRECORTO= "nombrecorto";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOIDENTIFICACION= "Tipo Identificacion";
		public static final String LABEL_IDTIPOIDENTIFICACION_LOWER= "Tipo Identificacion";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_APELLIDOPATERNO= "Apellido Paterno";
		public static final String LABEL_APELLIDOPATERNO_LOWER= "Apellido Paterno";
    	public static final String LABEL_APELLIDOMATERNO= "Apellido Materno";
		public static final String LABEL_APELLIDOMATERNO_LOWER= "Apellido Materno";
    	public static final String LABEL_PRIMERNOMBRE= "Primer Nombre";
		public static final String LABEL_PRIMERNOMBRE_LOWER= "Primer Nombre";
    	public static final String LABEL_SEGUNDONOMBRE= "Segundo Nombre";
		public static final String LABEL_SEGUNDONOMBRE_LOWER= "Segundo Nombre";
    	public static final String LABEL_NOMBRECORTO= "Nombre Corto";
		public static final String LABEL_NOMBRECORTO_LOWER= "Nombre Corto";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOPATERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOPATERNO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOMATERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOMATERNO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPRIMERNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPRIMERNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEGUNDONOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEGUNDONOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRECORTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRECORTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getConyugeLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConyugeConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.IDENTIFICACION)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.APELLIDOPATERNO)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_APELLIDOPATERNO;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.APELLIDOMATERNO)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_APELLIDOMATERNO;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.PRIMERNOMBRE)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_PRIMERNOMBRE;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.SEGUNDONOMBRE)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_SEGUNDONOMBRE;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.NOMBRECORTO)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_NOMBRECORTO;}
		if(sNombreColumna.equals(ConyugeConstantesFunciones.ESACTIVO)) {sLabelColumna=ConyugeConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(Conyuge conyuge) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!conyuge.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(Conyuge conyuge) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(conyuge.getId(),conyuge.getesactivo());

		return sDescripcion;
	}	
	
	public static String getConyugeDescripcion(Conyuge conyuge) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(conyuge !=null/* && conyuge.getId()!=0*/) {
			sDescripcion=conyuge.getapellidopaterno();//conyugeconyuge.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getConyugeDescripcionDetallado(Conyuge conyuge) {
		String sDescripcion="";
			
		sDescripcion+=ConyugeConstantesFunciones.ID+"=";
		sDescripcion+=conyuge.getId().toString()+",";
		sDescripcion+=ConyugeConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=conyuge.getVersionRow().toString()+",";
		sDescripcion+=ConyugeConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=conyuge.getidvaloridentificacion().toString()+",";
		sDescripcion+=ConyugeConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=conyuge.getidentificacion()+",";
		sDescripcion+=ConyugeConstantesFunciones.APELLIDOPATERNO+"=";
		sDescripcion+=conyuge.getapellidopaterno()+",";
		sDescripcion+=ConyugeConstantesFunciones.APELLIDOMATERNO+"=";
		sDescripcion+=conyuge.getapellidomaterno()+",";
		sDescripcion+=ConyugeConstantesFunciones.PRIMERNOMBRE+"=";
		sDescripcion+=conyuge.getprimernombre()+",";
		sDescripcion+=ConyugeConstantesFunciones.SEGUNDONOMBRE+"=";
		sDescripcion+=conyuge.getsegundonombre()+",";
		sDescripcion+=ConyugeConstantesFunciones.NOMBRECORTO+"=";
		sDescripcion+=conyuge.getnombrecorto()+",";
		sDescripcion+=ConyugeConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=conyuge.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConyugeDescripcion(Conyuge conyuge,String sValor) throws Exception {			
		if(conyuge !=null) {
			conyuge.setapellidopaterno(sValor);//conyugeconyuge.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("FK_IdValorIdentificacion")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Id="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorIdentificacion(Long idvaloridentificacion) {
		String sDetalleIndice=" Parametros->";
		if(idvaloridentificacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Identificacion="+idvaloridentificacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConyuge(Conyuge conyuge,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		conyuge.setidentificacion(conyuge.getidentificacion().trim());
		conyuge.setapellidopaterno(conyuge.getapellidopaterno().trim());
		conyuge.setapellidomaterno(conyuge.getapellidomaterno().trim());
		conyuge.setprimernombre(conyuge.getprimernombre().trim());
		conyuge.setsegundonombre(conyuge.getsegundonombre().trim());
		conyuge.setnombrecorto(conyuge.getnombrecorto().trim());
	}
	
	public static void quitarEspaciosConyuges(List<Conyuge> conyuges,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Conyuge conyuge: conyuges) {
			conyuge.setidentificacion(conyuge.getidentificacion().trim());
			conyuge.setapellidopaterno(conyuge.getapellidopaterno().trim());
			conyuge.setapellidomaterno(conyuge.getapellidomaterno().trim());
			conyuge.setprimernombre(conyuge.getprimernombre().trim());
			conyuge.setsegundonombre(conyuge.getsegundonombre().trim());
			conyuge.setnombrecorto(conyuge.getnombrecorto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConyuge(Conyuge conyuge,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && conyuge.getConCambioAuxiliar()) {
			conyuge.setIsDeleted(conyuge.getIsDeletedAuxiliar());	
			conyuge.setIsNew(conyuge.getIsNewAuxiliar());	
			conyuge.setIsChanged(conyuge.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			conyuge.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			conyuge.setIsDeletedAuxiliar(false);	
			conyuge.setIsNewAuxiliar(false);	
			conyuge.setIsChangedAuxiliar(false);
			
			conyuge.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConyuges(List<Conyuge> conyuges,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Conyuge conyuge : conyuges) {
			if(conAsignarBase && conyuge.getConCambioAuxiliar()) {
				conyuge.setIsDeleted(conyuge.getIsDeletedAuxiliar());	
				conyuge.setIsNew(conyuge.getIsNewAuxiliar());	
				conyuge.setIsChanged(conyuge.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				conyuge.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				conyuge.setIsDeletedAuxiliar(false);	
				conyuge.setIsNewAuxiliar(false);	
				conyuge.setIsChangedAuxiliar(false);
				
				conyuge.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConyuge(Conyuge conyuge,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConyuges(List<Conyuge> conyuges,Boolean conEnteros) throws Exception  {
		
		for(Conyuge conyuge: conyuges) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConyuge(List<Conyuge> conyuges,Conyuge conyugeAux) throws Exception  {
		ConyugeConstantesFunciones.InicializarValoresConyuge(conyugeAux,true);
		
		for(Conyuge conyuge: conyuges) {
			if(conyuge.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConyuge(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConyugeConstantesFunciones.getArrayColumnasGlobalesConyuge(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConyuge(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConyuge(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Conyuge> conyuges,Conyuge conyuge,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Conyuge conyugeAux: conyuges) {
			if(conyugeAux!=null && conyuge!=null) {
				if((conyugeAux.getId()==null && conyuge.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(conyugeAux.getId()!=null && conyuge.getId()!=null){
					if(conyugeAux.getId().equals(conyuge.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConyuge(List<Conyuge> conyuges) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Conyuge conyuge: conyuges) {			
			if(conyuge.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConyuge() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_ID, ConyugeConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_VERSIONROW, ConyugeConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, ConyugeConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_IDENTIFICACION, ConyugeConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_APELLIDOPATERNO, ConyugeConstantesFunciones.APELLIDOPATERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_APELLIDOMATERNO, ConyugeConstantesFunciones.APELLIDOMATERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_PRIMERNOMBRE, ConyugeConstantesFunciones.PRIMERNOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_SEGUNDONOMBRE, ConyugeConstantesFunciones.SEGUNDONOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_NOMBRECORTO, ConyugeConstantesFunciones.NOMBRECORTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConyugeConstantesFunciones.LABEL_ESACTIVO, ConyugeConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConyuge() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.APELLIDOPATERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.APELLIDOMATERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.PRIMERNOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.SEGUNDONOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.NOMBRECORTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConyugeConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConyuge() throws Exception  {
		return ConyugeConstantesFunciones.getTiposSeleccionarConyuge(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConyuge(Boolean conFk) throws Exception  {
		return ConyugeConstantesFunciones.getTiposSeleccionarConyuge(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConyuge(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_APELLIDOPATERNO);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_APELLIDOPATERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_APELLIDOMATERNO);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_APELLIDOMATERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_PRIMERNOMBRE);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_PRIMERNOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_SEGUNDONOMBRE);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_SEGUNDONOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_NOMBRECORTO);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_NOMBRECORTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConyugeConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(ConyugeConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConyuge(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConyuge(Conyuge conyugeAux) throws Exception {
		
			conyugeAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(conyugeAux.getCliente()));
			conyugeAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(conyugeAux.getTipoIdentificacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConyuge(List<Conyuge> conyugesTemp) throws Exception {
		for(Conyuge conyugeAux:conyugesTemp) {
			
			conyugeAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(conyugeAux.getCliente()));
			conyugeAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(conyugeAux.getTipoIdentificacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConyuge(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoIdentificacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConyuge(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConyuge(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConyugeConstantesFunciones.getClassesRelationshipsOfConyuge(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConyuge(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConyuge(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConyugeConstantesFunciones.getClassesRelationshipsFromStringsOfConyuge(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConyuge(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Conyuge conyuge,List<Conyuge> conyuges,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Conyuge conyugeEncontrado=null;
			
			for(Conyuge conyugeLocal:conyuges) {
				if(conyugeLocal.getId().equals(conyuge.getId())) {
					conyugeEncontrado=conyugeLocal;
					
					conyugeLocal.setIsChanged(conyuge.getIsChanged());
					conyugeLocal.setIsNew(conyuge.getIsNew());
					conyugeLocal.setIsDeleted(conyuge.getIsDeleted());
					
					conyugeLocal.setGeneralEntityOriginal(conyuge.getGeneralEntityOriginal());
					
					conyugeLocal.setId(conyuge.getId());	
					conyugeLocal.setVersionRow(conyuge.getVersionRow());	
					conyugeLocal.setidvaloridentificacion(conyuge.getidvaloridentificacion());	
					conyugeLocal.setidentificacion(conyuge.getidentificacion());	
					conyugeLocal.setapellidopaterno(conyuge.getapellidopaterno());	
					conyugeLocal.setapellidomaterno(conyuge.getapellidomaterno());	
					conyugeLocal.setprimernombre(conyuge.getprimernombre());	
					conyugeLocal.setsegundonombre(conyuge.getsegundonombre());	
					conyugeLocal.setnombrecorto(conyuge.getnombrecorto());	
					conyugeLocal.setesactivo(conyuge.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!conyuge.getIsDeleted()) {
				if(!existe) {
					conyuges.add(conyuge);
				}
			} else {
				if(conyugeEncontrado!=null && permiteQuitar)  {
					conyuges.remove(conyugeEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Conyuge conyuge,List<Conyuge> conyuges) throws Exception {
		try	{			
			for(Conyuge conyugeLocal:conyuges) {
				if(conyugeLocal.getId().equals(conyuge.getId())) {
					conyugeLocal.setIsSelected(conyuge.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConyuge(List<Conyuge> conyugesAux) throws Exception {
		//this.conyugesAux=conyugesAux;
		
		for(Conyuge conyugeAux:conyugesAux) {
			if(conyugeAux.getIsChanged()) {
				conyugeAux.setIsChanged(false);
			}		
			
			if(conyugeAux.getIsNew()) {
				conyugeAux.setIsNew(false);
			}	
			
			if(conyugeAux.getIsDeleted()) {
				conyugeAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConyuge(Conyuge conyugeAux) throws Exception {
		//this.conyugeAux=conyugeAux;
		
			if(conyugeAux.getIsChanged()) {
				conyugeAux.setIsChanged(false);
			}		
			
			if(conyugeAux.getIsNew()) {
				conyugeAux.setIsNew(false);
			}	
			
			if(conyugeAux.getIsDeleted()) {
				conyugeAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Conyuge conyugeAsignar,Conyuge conyuge) throws Exception {
		conyugeAsignar.setId(conyuge.getId());	
		conyugeAsignar.setVersionRow(conyuge.getVersionRow());	
		conyugeAsignar.setidvaloridentificacion(conyuge.getidvaloridentificacion());
		conyugeAsignar.settipoidentificacion_descripcion(conyuge.gettipoidentificacion_descripcion());	
		conyugeAsignar.setidentificacion(conyuge.getidentificacion());	
		conyugeAsignar.setapellidopaterno(conyuge.getapellidopaterno());	
		conyugeAsignar.setapellidomaterno(conyuge.getapellidomaterno());	
		conyugeAsignar.setprimernombre(conyuge.getprimernombre());	
		conyugeAsignar.setsegundonombre(conyuge.getsegundonombre());	
		conyugeAsignar.setnombrecorto(conyuge.getnombrecorto());	
		conyugeAsignar.setesactivo(conyuge.getesactivo());	
	}
	
	public static void inicializarConyuge(Conyuge conyuge) throws Exception {
		try {
				conyuge.setId(-1L);	
					
				conyuge.setidvaloridentificacion(-1L);	
				conyuge.setidentificacion("");	
				conyuge.setapellidopaterno("");	
				conyuge.setapellidomaterno("");	
				conyuge.setprimernombre("");	
				conyuge.setsegundonombre("");	
				conyuge.setnombrecorto("");	
				conyuge.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConyuge(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_APELLIDOPATERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_APELLIDOMATERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_PRIMERNOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_SEGUNDONOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_NOMBRECORTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConyugeConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConyuge(String sTipo,Row row,Workbook workbook,Conyuge conyuge,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.getapellidopaterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.getapellidomaterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.getprimernombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.getsegundonombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conyuge.getnombrecorto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(conyuge.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConyuge=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConyuge() {
		return this.sFinalQueryConyuge;
	}
	
	public void setsFinalQueryConyuge(String sFinalQueryConyuge) {
		this.sFinalQueryConyuge= sFinalQueryConyuge;
	}
	
	public Border resaltarSeleccionarConyuge=null;
	
	public Border setResaltarSeleccionarConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConyuge= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConyuge() {
		return this.resaltarSeleccionarConyuge;
	}
	
	public void setResaltarSeleccionarConyuge(Border borderResaltarSeleccionarConyuge) {
		this.resaltarSeleccionarConyuge= borderResaltarSeleccionarConyuge;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltarid_clienteConyuge=null;
	public Boolean mostrarid_clienteConyuge=true;
	public Boolean activarid_clienteConyuge=true;
	public Boolean cargarid_clienteConyuge=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteConyuge=false;//ConEventDepend=true

	public Border resaltaridvaloridentificacionConyuge=null;
	public Boolean mostraridvaloridentificacionConyuge=true;
	public Boolean activaridvaloridentificacionConyuge=true;
	public Boolean cargaridvaloridentificacionConyuge=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvaloridentificacionConyuge=false;//ConEventDepend=true

	public Border resaltaridentificacionConyuge=null;
	public Boolean mostraridentificacionConyuge=true;
	public Boolean activaridentificacionConyuge=true;

	public Border resaltarapellidopaternoConyuge=null;
	public Boolean mostrarapellidopaternoConyuge=true;
	public Boolean activarapellidopaternoConyuge=true;

	public Border resaltarapellidomaternoConyuge=null;
	public Boolean mostrarapellidomaternoConyuge=true;
	public Boolean activarapellidomaternoConyuge=true;

	public Border resaltarprimernombreConyuge=null;
	public Boolean mostrarprimernombreConyuge=true;
	public Boolean activarprimernombreConyuge=true;

	public Border resaltarsegundonombreConyuge=null;
	public Boolean mostrarsegundonombreConyuge=true;
	public Boolean activarsegundonombreConyuge=true;

	public Border resaltarnombrecortoConyuge=null;
	public Boolean mostrarnombrecortoConyuge=true;
	public Boolean activarnombrecortoConyuge=true;

	public Border resaltaresactivoConyuge=null;
	public Boolean mostraresactivoConyuge=true;
	public Boolean activaresactivoConyuge=true;

	
	

	public Border setResaltarid_clienteConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarid_clienteConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteConyuge() {
		return this.resaltarid_clienteConyuge;
	}

	public void setResaltarid_clienteConyuge(Border borderResaltar) {
		this.resaltarid_clienteConyuge= borderResaltar;
	}

	public Boolean getMostrarid_clienteConyuge() {
		return this.mostrarid_clienteConyuge;
	}

	public void setMostrarid_clienteConyuge(Boolean mostrarid_clienteConyuge) {
		this.mostrarid_clienteConyuge= mostrarid_clienteConyuge;
	}

	public Boolean getActivarid_clienteConyuge() {
		return this.activarid_clienteConyuge;
	}

	public void setActivarid_clienteConyuge(Boolean activarid_clienteConyuge) {
		this.activarid_clienteConyuge= activarid_clienteConyuge;
	}

	public Boolean getCargarid_clienteConyuge() {
		return this.cargarid_clienteConyuge;
	}

	public void setCargarid_clienteConyuge(Boolean cargarid_clienteConyuge) {
		this.cargarid_clienteConyuge= cargarid_clienteConyuge;
	}

	public Border setResaltaridvaloridentificacionConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltaridvaloridentificacionConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvaloridentificacionConyuge() {
		return this.resaltaridvaloridentificacionConyuge;
	}

	public void setResaltaridvaloridentificacionConyuge(Border borderResaltar) {
		this.resaltaridvaloridentificacionConyuge= borderResaltar;
	}

	public Boolean getMostraridvaloridentificacionConyuge() {
		return this.mostraridvaloridentificacionConyuge;
	}

	public void setMostraridvaloridentificacionConyuge(Boolean mostraridvaloridentificacionConyuge) {
		this.mostraridvaloridentificacionConyuge= mostraridvaloridentificacionConyuge;
	}

	public Boolean getActivaridvaloridentificacionConyuge() {
		return this.activaridvaloridentificacionConyuge;
	}

	public void setActivaridvaloridentificacionConyuge(Boolean activaridvaloridentificacionConyuge) {
		this.activaridvaloridentificacionConyuge= activaridvaloridentificacionConyuge;
	}

	public Boolean getCargaridvaloridentificacionConyuge() {
		return this.cargaridvaloridentificacionConyuge;
	}

	public void setCargaridvaloridentificacionConyuge(Boolean cargaridvaloridentificacionConyuge) {
		this.cargaridvaloridentificacionConyuge= cargaridvaloridentificacionConyuge;
	}

	public Border setResaltaridentificacionConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltaridentificacionConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionConyuge() {
		return this.resaltaridentificacionConyuge;
	}

	public void setResaltaridentificacionConyuge(Border borderResaltar) {
		this.resaltaridentificacionConyuge= borderResaltar;
	}

	public Boolean getMostraridentificacionConyuge() {
		return this.mostraridentificacionConyuge;
	}

	public void setMostraridentificacionConyuge(Boolean mostraridentificacionConyuge) {
		this.mostraridentificacionConyuge= mostraridentificacionConyuge;
	}

	public Boolean getActivaridentificacionConyuge() {
		return this.activaridentificacionConyuge;
	}

	public void setActivaridentificacionConyuge(Boolean activaridentificacionConyuge) {
		this.activaridentificacionConyuge= activaridentificacionConyuge;
	}

	public Border setResaltarapellidopaternoConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarapellidopaternoConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidopaternoConyuge() {
		return this.resaltarapellidopaternoConyuge;
	}

	public void setResaltarapellidopaternoConyuge(Border borderResaltar) {
		this.resaltarapellidopaternoConyuge= borderResaltar;
	}

	public Boolean getMostrarapellidopaternoConyuge() {
		return this.mostrarapellidopaternoConyuge;
	}

	public void setMostrarapellidopaternoConyuge(Boolean mostrarapellidopaternoConyuge) {
		this.mostrarapellidopaternoConyuge= mostrarapellidopaternoConyuge;
	}

	public Boolean getActivarapellidopaternoConyuge() {
		return this.activarapellidopaternoConyuge;
	}

	public void setActivarapellidopaternoConyuge(Boolean activarapellidopaternoConyuge) {
		this.activarapellidopaternoConyuge= activarapellidopaternoConyuge;
	}

	public Border setResaltarapellidomaternoConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarapellidomaternoConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidomaternoConyuge() {
		return this.resaltarapellidomaternoConyuge;
	}

	public void setResaltarapellidomaternoConyuge(Border borderResaltar) {
		this.resaltarapellidomaternoConyuge= borderResaltar;
	}

	public Boolean getMostrarapellidomaternoConyuge() {
		return this.mostrarapellidomaternoConyuge;
	}

	public void setMostrarapellidomaternoConyuge(Boolean mostrarapellidomaternoConyuge) {
		this.mostrarapellidomaternoConyuge= mostrarapellidomaternoConyuge;
	}

	public Boolean getActivarapellidomaternoConyuge() {
		return this.activarapellidomaternoConyuge;
	}

	public void setActivarapellidomaternoConyuge(Boolean activarapellidomaternoConyuge) {
		this.activarapellidomaternoConyuge= activarapellidomaternoConyuge;
	}

	public Border setResaltarprimernombreConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarprimernombreConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprimernombreConyuge() {
		return this.resaltarprimernombreConyuge;
	}

	public void setResaltarprimernombreConyuge(Border borderResaltar) {
		this.resaltarprimernombreConyuge= borderResaltar;
	}

	public Boolean getMostrarprimernombreConyuge() {
		return this.mostrarprimernombreConyuge;
	}

	public void setMostrarprimernombreConyuge(Boolean mostrarprimernombreConyuge) {
		this.mostrarprimernombreConyuge= mostrarprimernombreConyuge;
	}

	public Boolean getActivarprimernombreConyuge() {
		return this.activarprimernombreConyuge;
	}

	public void setActivarprimernombreConyuge(Boolean activarprimernombreConyuge) {
		this.activarprimernombreConyuge= activarprimernombreConyuge;
	}

	public Border setResaltarsegundonombreConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarsegundonombreConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsegundonombreConyuge() {
		return this.resaltarsegundonombreConyuge;
	}

	public void setResaltarsegundonombreConyuge(Border borderResaltar) {
		this.resaltarsegundonombreConyuge= borderResaltar;
	}

	public Boolean getMostrarsegundonombreConyuge() {
		return this.mostrarsegundonombreConyuge;
	}

	public void setMostrarsegundonombreConyuge(Boolean mostrarsegundonombreConyuge) {
		this.mostrarsegundonombreConyuge= mostrarsegundonombreConyuge;
	}

	public Boolean getActivarsegundonombreConyuge() {
		return this.activarsegundonombreConyuge;
	}

	public void setActivarsegundonombreConyuge(Boolean activarsegundonombreConyuge) {
		this.activarsegundonombreConyuge= activarsegundonombreConyuge;
	}

	public Border setResaltarnombrecortoConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltarnombrecortoConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrecortoConyuge() {
		return this.resaltarnombrecortoConyuge;
	}

	public void setResaltarnombrecortoConyuge(Border borderResaltar) {
		this.resaltarnombrecortoConyuge= borderResaltar;
	}

	public Boolean getMostrarnombrecortoConyuge() {
		return this.mostrarnombrecortoConyuge;
	}

	public void setMostrarnombrecortoConyuge(Boolean mostrarnombrecortoConyuge) {
		this.mostrarnombrecortoConyuge= mostrarnombrecortoConyuge;
	}

	public Boolean getActivarnombrecortoConyuge() {
		return this.activarnombrecortoConyuge;
	}

	public void setActivarnombrecortoConyuge(Boolean activarnombrecortoConyuge) {
		this.activarnombrecortoConyuge= activarnombrecortoConyuge;
	}

	public Border setResaltaresactivoConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conyugeBeanSwingJInternalFrame.jTtoolBarConyuge.setBorder(borderResaltar);
		
		this.resaltaresactivoConyuge= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoConyuge() {
		return this.resaltaresactivoConyuge;
	}

	public void setResaltaresactivoConyuge(Border borderResaltar) {
		this.resaltaresactivoConyuge= borderResaltar;
	}

	public Boolean getMostraresactivoConyuge() {
		return this.mostraresactivoConyuge;
	}

	public void setMostraresactivoConyuge(Boolean mostraresactivoConyuge) {
		this.mostraresactivoConyuge= mostraresactivoConyuge;
	}

	public Boolean getActivaresactivoConyuge() {
		return this.activaresactivoConyuge;
	}

	public void setActivaresactivoConyuge(Boolean activaresactivoConyuge) {
		this.activaresactivoConyuge= activaresactivoConyuge;
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
		
		
		this.setMostrarid_clienteConyuge(esInicial);
		this.setMostraridvaloridentificacionConyuge(esInicial);
		this.setMostraridentificacionConyuge(esInicial);
		this.setMostrarapellidopaternoConyuge(esInicial);
		this.setMostrarapellidomaternoConyuge(esInicial);
		this.setMostrarprimernombreConyuge(esInicial);
		this.setMostrarsegundonombreConyuge(esInicial);
		this.setMostrarnombrecortoConyuge(esInicial);
		this.setMostraresactivoConyuge(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConyugeConstantesFunciones.ID)) {
				this.setMostrarid_clienteConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostraridvaloridentificacionConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.APELLIDOPATERNO)) {
				this.setMostrarapellidopaternoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.APELLIDOMATERNO)) {
				this.setMostrarapellidomaternoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.PRIMERNOMBRE)) {
				this.setMostrarprimernombreConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.SEGUNDONOMBRE)) {
				this.setMostrarsegundonombreConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.NOMBRECORTO)) {
				this.setMostrarnombrecortoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoConyuge(esAsigna);
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
		
		
		this.setActivarid_clienteConyuge(esInicial);
		this.setActivaridvaloridentificacionConyuge(esInicial);
		this.setActivaridentificacionConyuge(esInicial);
		this.setActivarapellidopaternoConyuge(esInicial);
		this.setActivarapellidomaternoConyuge(esInicial);
		this.setActivarprimernombreConyuge(esInicial);
		this.setActivarsegundonombreConyuge(esInicial);
		this.setActivarnombrecortoConyuge(esInicial);
		this.setActivaresactivoConyuge(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConyugeConstantesFunciones.ID)) {
				this.setActivarid_clienteConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivaridvaloridentificacionConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.APELLIDOPATERNO)) {
				this.setActivarapellidopaternoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.APELLIDOMATERNO)) {
				this.setActivarapellidomaternoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.PRIMERNOMBRE)) {
				this.setActivarprimernombreConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.SEGUNDONOMBRE)) {
				this.setActivarsegundonombreConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.NOMBRECORTO)) {
				this.setActivarnombrecortoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoConyuge(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltarid_clienteConyuge(esInicial);
		this.setResaltaridvaloridentificacionConyuge(esInicial);
		this.setResaltaridentificacionConyuge(esInicial);
		this.setResaltarapellidopaternoConyuge(esInicial);
		this.setResaltarapellidomaternoConyuge(esInicial);
		this.setResaltarprimernombreConyuge(esInicial);
		this.setResaltarsegundonombreConyuge(esInicial);
		this.setResaltarnombrecortoConyuge(esInicial);
		this.setResaltaresactivoConyuge(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConyugeConstantesFunciones.ID)) {
				this.setResaltarid_clienteConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltaridvaloridentificacionConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.APELLIDOPATERNO)) {
				this.setResaltarapellidopaternoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.APELLIDOMATERNO)) {
				this.setResaltarapellidomaternoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.PRIMERNOMBRE)) {
				this.setResaltarprimernombreConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.SEGUNDONOMBRE)) {
				this.setResaltarsegundonombreConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.NOMBRECORTO)) {
				this.setResaltarnombrecortoConyuge(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConyugeConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoConyuge(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteConyuge=true;

	public Boolean getMostrarFK_IdClienteConyuge() {
		return this.mostrarFK_IdClienteConyuge;
	}

	public void setMostrarFK_IdClienteConyuge(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteConyuge= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorIdentificacionConyuge=true;

	public Boolean getMostrarFK_IdValorIdentificacionConyuge() {
		return this.mostrarFK_IdValorIdentificacionConyuge;
	}

	public void setMostrarFK_IdValorIdentificacionConyuge(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorIdentificacionConyuge= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteConyuge=true;

	public Boolean getActivarFK_IdClienteConyuge() {
		return this.activarFK_IdClienteConyuge;
	}

	public void setActivarFK_IdClienteConyuge(Boolean habilitarResaltar) {
		this.activarFK_IdClienteConyuge= habilitarResaltar;
	}

	public Boolean activarFK_IdValorIdentificacionConyuge=true;

	public Boolean getActivarFK_IdValorIdentificacionConyuge() {
		return this.activarFK_IdValorIdentificacionConyuge;
	}

	public void setActivarFK_IdValorIdentificacionConyuge(Boolean habilitarResaltar) {
		this.activarFK_IdValorIdentificacionConyuge= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteConyuge=null;

	public Border getResaltarFK_IdClienteConyuge() {
		return this.resaltarFK_IdClienteConyuge;
	}

	public void setResaltarFK_IdClienteConyuge(Border borderResaltar) {
		this.resaltarFK_IdClienteConyuge= borderResaltar;
	}

	public void setResaltarFK_IdClienteConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteConyuge= borderResaltar;
	}

	public Border resaltarFK_IdValorIdentificacionConyuge=null;

	public Border getResaltarFK_IdValorIdentificacionConyuge() {
		return this.resaltarFK_IdValorIdentificacionConyuge;
	}

	public void setResaltarFK_IdValorIdentificacionConyuge(Border borderResaltar) {
		this.resaltarFK_IdValorIdentificacionConyuge= borderResaltar;
	}

	public void setResaltarFK_IdValorIdentificacionConyuge(ParametroGeneralUsuario parametroGeneralUsuario/*ConyugeBeanSwingJInternalFrame conyugeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorIdentificacionConyuge= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}