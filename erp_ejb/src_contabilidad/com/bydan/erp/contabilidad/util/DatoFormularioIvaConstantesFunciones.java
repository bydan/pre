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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.DatoFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DatoFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DatoFormularioIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DatoFormularioIvaConstantesFunciones extends DatoFormularioIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DatoFormularioIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DatoFormularioIva"+DatoFormularioIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DatoFormularioIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DatoFormularioIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DatoFormularioIvaConstantesFunciones.SCHEMA+"_"+DatoFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DatoFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DatoFormularioIvaConstantesFunciones.SCHEMA+"_"+DatoFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DatoFormularioIvaConstantesFunciones.SCHEMA+"_"+DatoFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DatoFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DatoFormularioIvaConstantesFunciones.SCHEMA+"_"+DatoFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DatoFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DatoFormularioIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DatoFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DatoFormularioIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dato Formulario Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dato Formulario Iva";
	public static final String SCLASSWEBTITULO_LOWER="Dato Formulario Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DatoFormularioIva";
	public static final String OBJECTNAME="datoformularioiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="dato_formulario_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select datoformularioiva from "+DatoFormularioIvaConstantesFunciones.SPERSISTENCENAME+" datoformularioiva";
	public static String QUERYSELECTNATIVE="select "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".es_mensual,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id_anio,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id_mes,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id_semestre,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".es_sustitutiva,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".numero_formulario from "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME;//+" as "+DatoFormularioIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DatoFormularioIvaConstantesFuncionesAdditional datoformularioivaConstantesFuncionesAdditional=null;
	
	public DatoFormularioIvaConstantesFuncionesAdditional getDatoFormularioIvaConstantesFuncionesAdditional() {
		return this.datoformularioivaConstantesFuncionesAdditional;
	}
	
	public void setDatoFormularioIvaConstantesFuncionesAdditional(DatoFormularioIvaConstantesFuncionesAdditional datoformularioivaConstantesFuncionesAdditional) {
		try {
			this.datoformularioivaConstantesFuncionesAdditional=datoformularioivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String ESMENSUAL= "es_mensual";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDSEMESTRE= "id_semestre";
    public static final String ESSUSTITUTIVA= "es_sustitutiva";
    public static final String NUMEROFORMULARIO= "numero_formulario";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_ESMENSUAL= "Es Mensual";
		public static final String LABEL_ESMENSUAL_LOWER= "Es Mensual";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDSEMESTRE= "Semestre";
		public static final String LABEL_IDSEMESTRE_LOWER= "Semestre";
    	public static final String LABEL_ESSUSTITUTIVA= "Es Sustitutiva";
		public static final String LABEL_ESSUSTITUTIVA_LOWER= "Es Sustitutiva";
    	public static final String LABEL_NUMEROFORMULARIO= "Numero Formulario";
		public static final String LABEL_NUMEROFORMULARIO_LOWER= "Numero Formulario";
	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FORMULARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FORMULARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDatoFormularioIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DatoFormularioIvaConstantesFunciones.ESMENSUAL)) {sLabelColumna=DatoFormularioIvaConstantesFunciones.LABEL_ESMENSUAL;}
		if(sNombreColumna.equals(DatoFormularioIvaConstantesFunciones.IDANIO)) {sLabelColumna=DatoFormularioIvaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DatoFormularioIvaConstantesFunciones.IDMES)) {sLabelColumna=DatoFormularioIvaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DatoFormularioIvaConstantesFunciones.IDSEMESTRE)) {sLabelColumna=DatoFormularioIvaConstantesFunciones.LABEL_IDSEMESTRE;}
		if(sNombreColumna.equals(DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA)) {sLabelColumna=DatoFormularioIvaConstantesFunciones.LABEL_ESSUSTITUTIVA;}
		if(sNombreColumna.equals(DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO)) {sLabelColumna=DatoFormularioIvaConstantesFunciones.LABEL_NUMEROFORMULARIO;}
		
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
	
	
	
			
			
		
	public static String getes_mensualDescripcion(DatoFormularioIva datoformularioiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datoformularioiva.getes_mensual()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_mensualHtmlDescripcion(DatoFormularioIva datoformularioiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datoformularioiva.getId(),datoformularioiva.getes_mensual());

		return sDescripcion;
	}	
			
			
			
		
	public static String getes_sustitutivaDescripcion(DatoFormularioIva datoformularioiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datoformularioiva.getes_sustitutiva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_sustitutivaHtmlDescripcion(DatoFormularioIva datoformularioiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datoformularioiva.getId(),datoformularioiva.getes_sustitutiva());

		return sDescripcion;
	}	
			
	
	public static String getDatoFormularioIvaDescripcion(DatoFormularioIva datoformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(datoformularioiva !=null/* && datoformularioiva.getId()!=0*/) {
			if(datoformularioiva.getId()!=null) {
				sDescripcion=datoformularioiva.getId().toString();
			}//datoformularioivadatoformularioiva.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDatoFormularioIvaDescripcionDetallado(DatoFormularioIva datoformularioiva) {
		String sDescripcion="";
			
		sDescripcion+=DatoFormularioIvaConstantesFunciones.ID+"=";
		sDescripcion+=datoformularioiva.getId().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=datoformularioiva.getVersionRow().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.ESMENSUAL+"=";
		sDescripcion+=datoformularioiva.getes_mensual().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.IDANIO+"=";
		sDescripcion+=datoformularioiva.getid_anio().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.IDMES+"=";
		sDescripcion+=datoformularioiva.getid_mes().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.IDSEMESTRE+"=";
		sDescripcion+=datoformularioiva.getid_semestre().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA+"=";
		sDescripcion+=datoformularioiva.getes_sustitutiva().toString()+",";
		sDescripcion+=DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO+"=";
		sDescripcion+=datoformularioiva.getnumero_formulario()+",";
			
		return sDescripcion;
	}
	
	public static void setDatoFormularioIvaDescripcion(DatoFormularioIva datoformularioiva,String sValor) throws Exception {			
		if(datoformularioiva !=null) {
			//datoformularioivadatoformularioiva.getId().toString();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getSemestreDescripcion(Semestre semestre) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(semestre!=null/*&&semestre.getId()>0*/) {
			sDescripcion=SemestreConstantesFunciones.getSemestreDescripcion(semestre);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdAnioIdSemestre")) {
			sNombreIndice="Tipo=  Por Anio Por Semestre";
		} else if(sNombreIndice.equals("BusquedaPorIdAnioPorIdMes")) {
			sNombreIndice="Tipo=  Por Anio Por Mes";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdSemestre")) {
			sNombreIndice="Tipo=  Por Semestre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdAnioIdSemestre(Long id_anio,Long id_semestre) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_semestre!=null) {sDetalleIndice+=" Codigo Unico De Semestre="+id_semestre.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIdAnioPorIdMes(Long id_anio,Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSemestre(Long id_semestre) {
		String sDetalleIndice=" Parametros->";
		if(id_semestre!=null) {sDetalleIndice+=" Codigo Unico De Semestre="+id_semestre.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDatoFormularioIva(DatoFormularioIva datoformularioiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		datoformularioiva.setnumero_formulario(datoformularioiva.getnumero_formulario().trim());
	}
	
	public static void quitarEspaciosDatoFormularioIvas(List<DatoFormularioIva> datoformularioivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DatoFormularioIva datoformularioiva: datoformularioivas) {
			datoformularioiva.setnumero_formulario(datoformularioiva.getnumero_formulario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoFormularioIva(DatoFormularioIva datoformularioiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && datoformularioiva.getConCambioAuxiliar()) {
			datoformularioiva.setIsDeleted(datoformularioiva.getIsDeletedAuxiliar());	
			datoformularioiva.setIsNew(datoformularioiva.getIsNewAuxiliar());	
			datoformularioiva.setIsChanged(datoformularioiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			datoformularioiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			datoformularioiva.setIsDeletedAuxiliar(false);	
			datoformularioiva.setIsNewAuxiliar(false);	
			datoformularioiva.setIsChangedAuxiliar(false);
			
			datoformularioiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoFormularioIvas(List<DatoFormularioIva> datoformularioivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DatoFormularioIva datoformularioiva : datoformularioivas) {
			if(conAsignarBase && datoformularioiva.getConCambioAuxiliar()) {
				datoformularioiva.setIsDeleted(datoformularioiva.getIsDeletedAuxiliar());	
				datoformularioiva.setIsNew(datoformularioiva.getIsNewAuxiliar());	
				datoformularioiva.setIsChanged(datoformularioiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				datoformularioiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				datoformularioiva.setIsDeletedAuxiliar(false);	
				datoformularioiva.setIsNewAuxiliar(false);	
				datoformularioiva.setIsChangedAuxiliar(false);
				
				datoformularioiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDatoFormularioIva(DatoFormularioIva datoformularioiva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDatoFormularioIvas(List<DatoFormularioIva> datoformularioivas,Boolean conEnteros) throws Exception  {
		
		for(DatoFormularioIva datoformularioiva: datoformularioivas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDatoFormularioIva(List<DatoFormularioIva> datoformularioivas,DatoFormularioIva datoformularioivaAux) throws Exception  {
		DatoFormularioIvaConstantesFunciones.InicializarValoresDatoFormularioIva(datoformularioivaAux,true);
		
		for(DatoFormularioIva datoformularioiva: datoformularioivas) {
			if(datoformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DatoFormularioIvaConstantesFunciones.getArrayColumnasGlobalesDatoFormularioIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDatoFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DatoFormularioIva> datoformularioivas,DatoFormularioIva datoformularioiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DatoFormularioIva datoformularioivaAux: datoformularioivas) {
			if(datoformularioivaAux!=null && datoformularioiva!=null) {
				if((datoformularioivaAux.getId()==null && datoformularioiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(datoformularioivaAux.getId()!=null && datoformularioiva.getId()!=null){
					if(datoformularioivaAux.getId().equals(datoformularioiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDatoFormularioIva(List<DatoFormularioIva> datoformularioivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DatoFormularioIva datoformularioiva: datoformularioivas) {			
			if(datoformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDatoFormularioIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_ID, DatoFormularioIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_VERSIONROW, DatoFormularioIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_ESMENSUAL, DatoFormularioIvaConstantesFunciones.ESMENSUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_IDANIO, DatoFormularioIvaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_IDMES, DatoFormularioIvaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_IDSEMESTRE, DatoFormularioIvaConstantesFunciones.IDSEMESTRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_ESSUSTITUTIVA, DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioIvaConstantesFunciones.LABEL_NUMEROFORMULARIO, DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDatoFormularioIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.ESMENSUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.IDSEMESTRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoFormularioIva() throws Exception  {
		return DatoFormularioIvaConstantesFunciones.getTiposSeleccionarDatoFormularioIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoFormularioIva(Boolean conFk) throws Exception  {
		return DatoFormularioIvaConstantesFunciones.getTiposSeleccionarDatoFormularioIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoFormularioIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioIvaConstantesFunciones.LABEL_ESMENSUAL);
			reporte.setsDescripcion(DatoFormularioIvaConstantesFunciones.LABEL_ESMENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioIvaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DatoFormularioIvaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioIvaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DatoFormularioIvaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioIvaConstantesFunciones.LABEL_IDSEMESTRE);
			reporte.setsDescripcion(DatoFormularioIvaConstantesFunciones.LABEL_IDSEMESTRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioIvaConstantesFunciones.LABEL_ESSUSTITUTIVA);
			reporte.setsDescripcion(DatoFormularioIvaConstantesFunciones.LABEL_ESSUSTITUTIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioIvaConstantesFunciones.LABEL_NUMEROFORMULARIO);
			reporte.setsDescripcion(DatoFormularioIvaConstantesFunciones.LABEL_NUMEROFORMULARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDatoFormularioIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDatoFormularioIva(DatoFormularioIva datoformularioivaAux) throws Exception {
		
			datoformularioivaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(datoformularioivaAux.getAnio()));
			datoformularioivaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(datoformularioivaAux.getMes()));
			datoformularioivaAux.setsemestre_descripcion(SemestreConstantesFunciones.getSemestreDescripcion(datoformularioivaAux.getSemestre()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDatoFormularioIva(List<DatoFormularioIva> datoformularioivasTemp) throws Exception {
		for(DatoFormularioIva datoformularioivaAux:datoformularioivasTemp) {
			
			datoformularioivaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(datoformularioivaAux.getAnio()));
			datoformularioivaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(datoformularioivaAux.getMes()));
			datoformularioivaAux.setsemestre_descripcion(SemestreConstantesFunciones.getSemestreDescripcion(datoformularioivaAux.getSemestre()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDatoFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Semestre.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Semestre.class)) {
						classes.add(new Classe(Semestre.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDatoFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Semestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Semestre.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Semestre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Semestre.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoFormularioIvaConstantesFunciones.getClassesRelationshipsOfDatoFormularioIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormularioIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioIva.class)) {
						classes.add(new Classe(FormularioIva.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoFormularioIvaConstantesFunciones.getClassesRelationshipsFromStringsOfDatoFormularioIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioIva.class)); continue;
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
	public static void actualizarLista(DatoFormularioIva datoformularioiva,List<DatoFormularioIva> datoformularioivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DatoFormularioIva datoformularioivaEncontrado=null;
			
			for(DatoFormularioIva datoformularioivaLocal:datoformularioivas) {
				if(datoformularioivaLocal.getId().equals(datoformularioiva.getId())) {
					datoformularioivaEncontrado=datoformularioivaLocal;
					
					datoformularioivaLocal.setIsChanged(datoformularioiva.getIsChanged());
					datoformularioivaLocal.setIsNew(datoformularioiva.getIsNew());
					datoformularioivaLocal.setIsDeleted(datoformularioiva.getIsDeleted());
					
					datoformularioivaLocal.setGeneralEntityOriginal(datoformularioiva.getGeneralEntityOriginal());
					
					datoformularioivaLocal.setId(datoformularioiva.getId());	
					datoformularioivaLocal.setVersionRow(datoformularioiva.getVersionRow());	
					datoformularioivaLocal.setes_mensual(datoformularioiva.getes_mensual());	
					datoformularioivaLocal.setid_anio(datoformularioiva.getid_anio());	
					datoformularioivaLocal.setid_mes(datoformularioiva.getid_mes());	
					datoformularioivaLocal.setid_semestre(datoformularioiva.getid_semestre());	
					datoformularioivaLocal.setes_sustitutiva(datoformularioiva.getes_sustitutiva());	
					datoformularioivaLocal.setnumero_formulario(datoformularioiva.getnumero_formulario());	
					
					
					datoformularioivaLocal.setFormularioIvas(datoformularioiva.getFormularioIvas());
					
					existe=true;
					break;
				}
			}
			
			if(!datoformularioiva.getIsDeleted()) {
				if(!existe) {
					datoformularioivas.add(datoformularioiva);
				}
			} else {
				if(datoformularioivaEncontrado!=null && permiteQuitar)  {
					datoformularioivas.remove(datoformularioivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DatoFormularioIva datoformularioiva,List<DatoFormularioIva> datoformularioivas) throws Exception {
		try	{			
			for(DatoFormularioIva datoformularioivaLocal:datoformularioivas) {
				if(datoformularioivaLocal.getId().equals(datoformularioiva.getId())) {
					datoformularioivaLocal.setIsSelected(datoformularioiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDatoFormularioIva(List<DatoFormularioIva> datoformularioivasAux) throws Exception {
		//this.datoformularioivasAux=datoformularioivasAux;
		
		for(DatoFormularioIva datoformularioivaAux:datoformularioivasAux) {
			if(datoformularioivaAux.getIsChanged()) {
				datoformularioivaAux.setIsChanged(false);
			}		
			
			if(datoformularioivaAux.getIsNew()) {
				datoformularioivaAux.setIsNew(false);
			}	
			
			if(datoformularioivaAux.getIsDeleted()) {
				datoformularioivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDatoFormularioIva(DatoFormularioIva datoformularioivaAux) throws Exception {
		//this.datoformularioivaAux=datoformularioivaAux;
		
			if(datoformularioivaAux.getIsChanged()) {
				datoformularioivaAux.setIsChanged(false);
			}		
			
			if(datoformularioivaAux.getIsNew()) {
				datoformularioivaAux.setIsNew(false);
			}	
			
			if(datoformularioivaAux.getIsDeleted()) {
				datoformularioivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DatoFormularioIva datoformularioivaAsignar,DatoFormularioIva datoformularioiva) throws Exception {
		datoformularioivaAsignar.setId(datoformularioiva.getId());	
		datoformularioivaAsignar.setVersionRow(datoformularioiva.getVersionRow());	
		datoformularioivaAsignar.setes_mensual(datoformularioiva.getes_mensual());	
		datoformularioivaAsignar.setid_anio(datoformularioiva.getid_anio());
		datoformularioivaAsignar.setanio_descripcion(datoformularioiva.getanio_descripcion());	
		datoformularioivaAsignar.setid_mes(datoformularioiva.getid_mes());
		datoformularioivaAsignar.setmes_descripcion(datoformularioiva.getmes_descripcion());	
		datoformularioivaAsignar.setid_semestre(datoformularioiva.getid_semestre());
		datoformularioivaAsignar.setsemestre_descripcion(datoformularioiva.getsemestre_descripcion());	
		datoformularioivaAsignar.setes_sustitutiva(datoformularioiva.getes_sustitutiva());	
		datoformularioivaAsignar.setnumero_formulario(datoformularioiva.getnumero_formulario());	
	}
	
	public static void inicializarDatoFormularioIva(DatoFormularioIva datoformularioiva) throws Exception {
		try {
				datoformularioiva.setId(0L);	
					
				datoformularioiva.setes_mensual(false);	
				datoformularioiva.setid_anio(null);	
				datoformularioiva.setid_mes(null);	
				datoformularioiva.setid_semestre(-1L);	
				datoformularioiva.setes_sustitutiva(false);	
				datoformularioiva.setnumero_formulario("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDatoFormularioIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioIvaConstantesFunciones.LABEL_ESMENSUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioIvaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioIvaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioIvaConstantesFunciones.LABEL_IDSEMESTRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioIvaConstantesFunciones.LABEL_ESSUSTITUTIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioIvaConstantesFunciones.LABEL_NUMEROFORMULARIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDatoFormularioIva(String sTipo,Row row,Workbook workbook,DatoFormularioIva datoformularioiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datoformularioiva.getes_mensual()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformularioiva.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformularioiva.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformularioiva.getsemestre_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datoformularioiva.getes_sustitutiva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformularioiva.getnumero_formulario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDatoFormularioIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDatoFormularioIva() {
		return this.sFinalQueryDatoFormularioIva;
	}
	
	public void setsFinalQueryDatoFormularioIva(String sFinalQueryDatoFormularioIva) {
		this.sFinalQueryDatoFormularioIva= sFinalQueryDatoFormularioIva;
	}
	
	public Border resaltarSeleccionarDatoFormularioIva=null;
	
	public Border setResaltarSeleccionarDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDatoFormularioIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDatoFormularioIva() {
		return this.resaltarSeleccionarDatoFormularioIva;
	}
	
	public void setResaltarSeleccionarDatoFormularioIva(Border borderResaltarSeleccionarDatoFormularioIva) {
		this.resaltarSeleccionarDatoFormularioIva= borderResaltarSeleccionarDatoFormularioIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDatoFormularioIva=null;
	public Boolean mostraridDatoFormularioIva=true;
	public Boolean activaridDatoFormularioIva=true;

	public Border resaltares_mensualDatoFormularioIva=null;
	public Boolean mostrares_mensualDatoFormularioIva=true;
	public Boolean activares_mensualDatoFormularioIva=true;

	public Border resaltarid_anioDatoFormularioIva=null;
	public Boolean mostrarid_anioDatoFormularioIva=true;
	public Boolean activarid_anioDatoFormularioIva=true;
	public Boolean cargarid_anioDatoFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDatoFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_mesDatoFormularioIva=null;
	public Boolean mostrarid_mesDatoFormularioIva=true;
	public Boolean activarid_mesDatoFormularioIva=true;
	public Boolean cargarid_mesDatoFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDatoFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_semestreDatoFormularioIva=null;
	public Boolean mostrarid_semestreDatoFormularioIva=true;
	public Boolean activarid_semestreDatoFormularioIva=true;
	public Boolean cargarid_semestreDatoFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_semestreDatoFormularioIva=false;//ConEventDepend=true

	public Border resaltares_sustitutivaDatoFormularioIva=null;
	public Boolean mostrares_sustitutivaDatoFormularioIva=true;
	public Boolean activares_sustitutivaDatoFormularioIva=true;

	public Border resaltarnumero_formularioDatoFormularioIva=null;
	public Boolean mostrarnumero_formularioDatoFormularioIva=true;
	public Boolean activarnumero_formularioDatoFormularioIva=true;

	
	

	public Border setResaltaridDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltaridDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDatoFormularioIva() {
		return this.resaltaridDatoFormularioIva;
	}

	public void setResaltaridDatoFormularioIva(Border borderResaltar) {
		this.resaltaridDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostraridDatoFormularioIva() {
		return this.mostraridDatoFormularioIva;
	}

	public void setMostraridDatoFormularioIva(Boolean mostraridDatoFormularioIva) {
		this.mostraridDatoFormularioIva= mostraridDatoFormularioIva;
	}

	public Boolean getActivaridDatoFormularioIva() {
		return this.activaridDatoFormularioIva;
	}

	public void setActivaridDatoFormularioIva(Boolean activaridDatoFormularioIva) {
		this.activaridDatoFormularioIva= activaridDatoFormularioIva;
	}

	public Border setResaltares_mensualDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltares_mensualDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_mensualDatoFormularioIva() {
		return this.resaltares_mensualDatoFormularioIva;
	}

	public void setResaltares_mensualDatoFormularioIva(Border borderResaltar) {
		this.resaltares_mensualDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostrares_mensualDatoFormularioIva() {
		return this.mostrares_mensualDatoFormularioIva;
	}

	public void setMostrares_mensualDatoFormularioIva(Boolean mostrares_mensualDatoFormularioIva) {
		this.mostrares_mensualDatoFormularioIva= mostrares_mensualDatoFormularioIva;
	}

	public Boolean getActivares_mensualDatoFormularioIva() {
		return this.activares_mensualDatoFormularioIva;
	}

	public void setActivares_mensualDatoFormularioIva(Boolean activares_mensualDatoFormularioIva) {
		this.activares_mensualDatoFormularioIva= activares_mensualDatoFormularioIva;
	}

	public Border setResaltarid_anioDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_anioDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDatoFormularioIva() {
		return this.resaltarid_anioDatoFormularioIva;
	}

	public void setResaltarid_anioDatoFormularioIva(Border borderResaltar) {
		this.resaltarid_anioDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_anioDatoFormularioIva() {
		return this.mostrarid_anioDatoFormularioIva;
	}

	public void setMostrarid_anioDatoFormularioIva(Boolean mostrarid_anioDatoFormularioIva) {
		this.mostrarid_anioDatoFormularioIva= mostrarid_anioDatoFormularioIva;
	}

	public Boolean getActivarid_anioDatoFormularioIva() {
		return this.activarid_anioDatoFormularioIva;
	}

	public void setActivarid_anioDatoFormularioIva(Boolean activarid_anioDatoFormularioIva) {
		this.activarid_anioDatoFormularioIva= activarid_anioDatoFormularioIva;
	}

	public Boolean getCargarid_anioDatoFormularioIva() {
		return this.cargarid_anioDatoFormularioIva;
	}

	public void setCargarid_anioDatoFormularioIva(Boolean cargarid_anioDatoFormularioIva) {
		this.cargarid_anioDatoFormularioIva= cargarid_anioDatoFormularioIva;
	}

	public Border setResaltarid_mesDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_mesDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDatoFormularioIva() {
		return this.resaltarid_mesDatoFormularioIva;
	}

	public void setResaltarid_mesDatoFormularioIva(Border borderResaltar) {
		this.resaltarid_mesDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_mesDatoFormularioIva() {
		return this.mostrarid_mesDatoFormularioIva;
	}

	public void setMostrarid_mesDatoFormularioIva(Boolean mostrarid_mesDatoFormularioIva) {
		this.mostrarid_mesDatoFormularioIva= mostrarid_mesDatoFormularioIva;
	}

	public Boolean getActivarid_mesDatoFormularioIva() {
		return this.activarid_mesDatoFormularioIva;
	}

	public void setActivarid_mesDatoFormularioIva(Boolean activarid_mesDatoFormularioIva) {
		this.activarid_mesDatoFormularioIva= activarid_mesDatoFormularioIva;
	}

	public Boolean getCargarid_mesDatoFormularioIva() {
		return this.cargarid_mesDatoFormularioIva;
	}

	public void setCargarid_mesDatoFormularioIva(Boolean cargarid_mesDatoFormularioIva) {
		this.cargarid_mesDatoFormularioIva= cargarid_mesDatoFormularioIva;
	}

	public Border setResaltarid_semestreDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_semestreDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_semestreDatoFormularioIva() {
		return this.resaltarid_semestreDatoFormularioIva;
	}

	public void setResaltarid_semestreDatoFormularioIva(Border borderResaltar) {
		this.resaltarid_semestreDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_semestreDatoFormularioIva() {
		return this.mostrarid_semestreDatoFormularioIva;
	}

	public void setMostrarid_semestreDatoFormularioIva(Boolean mostrarid_semestreDatoFormularioIva) {
		this.mostrarid_semestreDatoFormularioIva= mostrarid_semestreDatoFormularioIva;
	}

	public Boolean getActivarid_semestreDatoFormularioIva() {
		return this.activarid_semestreDatoFormularioIva;
	}

	public void setActivarid_semestreDatoFormularioIva(Boolean activarid_semestreDatoFormularioIva) {
		this.activarid_semestreDatoFormularioIva= activarid_semestreDatoFormularioIva;
	}

	public Boolean getCargarid_semestreDatoFormularioIva() {
		return this.cargarid_semestreDatoFormularioIva;
	}

	public void setCargarid_semestreDatoFormularioIva(Boolean cargarid_semestreDatoFormularioIva) {
		this.cargarid_semestreDatoFormularioIva= cargarid_semestreDatoFormularioIva;
	}

	public Border setResaltares_sustitutivaDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltares_sustitutivaDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_sustitutivaDatoFormularioIva() {
		return this.resaltares_sustitutivaDatoFormularioIva;
	}

	public void setResaltares_sustitutivaDatoFormularioIva(Border borderResaltar) {
		this.resaltares_sustitutivaDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostrares_sustitutivaDatoFormularioIva() {
		return this.mostrares_sustitutivaDatoFormularioIva;
	}

	public void setMostrares_sustitutivaDatoFormularioIva(Boolean mostrares_sustitutivaDatoFormularioIva) {
		this.mostrares_sustitutivaDatoFormularioIva= mostrares_sustitutivaDatoFormularioIva;
	}

	public Boolean getActivares_sustitutivaDatoFormularioIva() {
		return this.activares_sustitutivaDatoFormularioIva;
	}

	public void setActivares_sustitutivaDatoFormularioIva(Boolean activares_sustitutivaDatoFormularioIva) {
		this.activares_sustitutivaDatoFormularioIva= activares_sustitutivaDatoFormularioIva;
	}

	public Border setResaltarnumero_formularioDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltar);
		
		this.resaltarnumero_formularioDatoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_formularioDatoFormularioIva() {
		return this.resaltarnumero_formularioDatoFormularioIva;
	}

	public void setResaltarnumero_formularioDatoFormularioIva(Border borderResaltar) {
		this.resaltarnumero_formularioDatoFormularioIva= borderResaltar;
	}

	public Boolean getMostrarnumero_formularioDatoFormularioIva() {
		return this.mostrarnumero_formularioDatoFormularioIva;
	}

	public void setMostrarnumero_formularioDatoFormularioIva(Boolean mostrarnumero_formularioDatoFormularioIva) {
		this.mostrarnumero_formularioDatoFormularioIva= mostrarnumero_formularioDatoFormularioIva;
	}

	public Boolean getActivarnumero_formularioDatoFormularioIva() {
		return this.activarnumero_formularioDatoFormularioIva;
	}

	public void setActivarnumero_formularioDatoFormularioIva(Boolean activarnumero_formularioDatoFormularioIva) {
		this.activarnumero_formularioDatoFormularioIva= activarnumero_formularioDatoFormularioIva;
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
		
		
		this.setMostraridDatoFormularioIva(esInicial);
		this.setMostrares_mensualDatoFormularioIva(esInicial);
		this.setMostrarid_anioDatoFormularioIva(esInicial);
		this.setMostrarid_mesDatoFormularioIva(esInicial);
		this.setMostrarid_semestreDatoFormularioIva(esInicial);
		this.setMostrares_sustitutivaDatoFormularioIva(esInicial);
		this.setMostrarnumero_formularioDatoFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ID)) {
				this.setMostraridDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ESMENSUAL)) {
				this.setMostrares_mensualDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDSEMESTRE)) {
				this.setMostrarid_semestreDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA)) {
				this.setMostrares_sustitutivaDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO)) {
				this.setMostrarnumero_formularioDatoFormularioIva(esAsigna);
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
		
		
		this.setActivaridDatoFormularioIva(esInicial);
		this.setActivares_mensualDatoFormularioIva(esInicial);
		this.setActivarid_anioDatoFormularioIva(esInicial);
		this.setActivarid_mesDatoFormularioIva(esInicial);
		this.setActivarid_semestreDatoFormularioIva(esInicial);
		this.setActivares_sustitutivaDatoFormularioIva(esInicial);
		this.setActivarnumero_formularioDatoFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ID)) {
				this.setActivaridDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ESMENSUAL)) {
				this.setActivares_mensualDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDMES)) {
				this.setActivarid_mesDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDSEMESTRE)) {
				this.setActivarid_semestreDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA)) {
				this.setActivares_sustitutivaDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO)) {
				this.setActivarnumero_formularioDatoFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDatoFormularioIva(esInicial);
		this.setResaltares_mensualDatoFormularioIva(esInicial);
		this.setResaltarid_anioDatoFormularioIva(esInicial);
		this.setResaltarid_mesDatoFormularioIva(esInicial);
		this.setResaltarid_semestreDatoFormularioIva(esInicial);
		this.setResaltares_sustitutivaDatoFormularioIva(esInicial);
		this.setResaltarnumero_formularioDatoFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ID)) {
				this.setResaltaridDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ESMENSUAL)) {
				this.setResaltares_mensualDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.IDSEMESTRE)) {
				this.setResaltarid_semestreDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA)) {
				this.setResaltares_sustitutivaDatoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO)) {
				this.setResaltarnumero_formularioDatoFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormularioIvaDatoFormularioIva=null;

	public Border getResaltarFormularioIvaDatoFormularioIva() {
		return this.resaltarFormularioIvaDatoFormularioIva;
	}

	public void setResaltarFormularioIvaDatoFormularioIva(Border borderResaltarFormularioIva) {
		if(borderResaltarFormularioIva!=null) {
			this.resaltarFormularioIvaDatoFormularioIva= borderResaltarFormularioIva;
		}
	}

	public Border setResaltarFormularioIvaDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioIva=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//datoformularioivaBeanSwingJInternalFrame.jTtoolBarDatoFormularioIva.setBorder(borderResaltarFormularioIva);
			
		this.resaltarFormularioIvaDatoFormularioIva= borderResaltarFormularioIva;

		 return borderResaltarFormularioIva;
	}



	public Boolean mostrarFormularioIvaDatoFormularioIva=true;

	public Boolean getMostrarFormularioIvaDatoFormularioIva() {
		return this.mostrarFormularioIvaDatoFormularioIva;
	}

	public void setMostrarFormularioIvaDatoFormularioIva(Boolean visibilidadResaltarFormularioIva) {
		this.mostrarFormularioIvaDatoFormularioIva= visibilidadResaltarFormularioIva;
	}



	public Boolean activarFormularioIvaDatoFormularioIva=true;

	public Boolean gethabilitarResaltarFormularioIvaDatoFormularioIva() {
		return this.activarFormularioIvaDatoFormularioIva;
	}

	public void setActivarFormularioIvaDatoFormularioIva(Boolean habilitarResaltarFormularioIva) {
		this.activarFormularioIvaDatoFormularioIva= habilitarResaltarFormularioIva;
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

		this.setMostrarFormularioIvaDatoFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioIva.class)) {
				this.setMostrarFormularioIvaDatoFormularioIva(esAsigna);
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

		this.setActivarFormularioIvaDatoFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioIva.class)) {
				this.setActivarFormularioIvaDatoFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormularioIvaDatoFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioIva.class)) {
				this.setResaltarFormularioIvaDatoFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdAnioIdSemestreDatoFormularioIva=true;

	public Boolean getMostrarBusquedaPorIdAnioIdSemestreDatoFormularioIva() {
		return this.mostrarBusquedaPorIdAnioIdSemestreDatoFormularioIva;
	}

	public void setMostrarBusquedaPorIdAnioIdSemestreDatoFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdAnioIdSemestreDatoFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdAnioPorIdMesDatoFormularioIva=true;

	public Boolean getMostrarBusquedaPorIdAnioPorIdMesDatoFormularioIva() {
		return this.mostrarBusquedaPorIdAnioPorIdMesDatoFormularioIva;
	}

	public void setMostrarBusquedaPorIdAnioPorIdMesDatoFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdAnioPorIdMesDatoFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAnioDatoFormularioIva=true;

	public Boolean getMostrarFK_IdAnioDatoFormularioIva() {
		return this.mostrarFK_IdAnioDatoFormularioIva;
	}

	public void setMostrarFK_IdAnioDatoFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioDatoFormularioIva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdAnioIdSemestreDatoFormularioIva=true;

	public Boolean getActivarBusquedaPorIdAnioIdSemestreDatoFormularioIva() {
		return this.activarBusquedaPorIdAnioIdSemestreDatoFormularioIva;
	}

	public void setActivarBusquedaPorIdAnioIdSemestreDatoFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdAnioIdSemestreDatoFormularioIva= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdAnioPorIdMesDatoFormularioIva=true;

	public Boolean getActivarBusquedaPorIdAnioPorIdMesDatoFormularioIva() {
		return this.activarBusquedaPorIdAnioPorIdMesDatoFormularioIva;
	}

	public void setActivarBusquedaPorIdAnioPorIdMesDatoFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdAnioPorIdMesDatoFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdAnioDatoFormularioIva=true;

	public Boolean getActivarFK_IdAnioDatoFormularioIva() {
		return this.activarFK_IdAnioDatoFormularioIva;
	}

	public void setActivarFK_IdAnioDatoFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdAnioDatoFormularioIva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva=null;

	public Border getResaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva() {
		return this.resaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva;
	}

	public void setResaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdAnioIdSemestreDatoFormularioIva= borderResaltar;
	}

	public Border resaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva=null;

	public Border getResaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva() {
		return this.resaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva;
	}

	public void setResaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdAnioPorIdMesDatoFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdAnioDatoFormularioIva=null;

	public Border getResaltarFK_IdAnioDatoFormularioIva() {
		return this.resaltarFK_IdAnioDatoFormularioIva;
	}

	public void setResaltarFK_IdAnioDatoFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdAnioDatoFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdAnioDatoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioIvaBeanSwingJInternalFrame datoformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioDatoFormularioIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}