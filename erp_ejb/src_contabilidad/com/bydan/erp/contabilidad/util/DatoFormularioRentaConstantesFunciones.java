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


import com.bydan.erp.contabilidad.util.DatoFormularioRentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DatoFormularioRentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DatoFormularioRentaParameterGeneral;

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
final public class DatoFormularioRentaConstantesFunciones extends DatoFormularioRentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DatoFormularioRenta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DatoFormularioRenta"+DatoFormularioRentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DatoFormularioRentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DatoFormularioRentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DatoFormularioRentaConstantesFunciones.SCHEMA+"_"+DatoFormularioRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DatoFormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DatoFormularioRentaConstantesFunciones.SCHEMA+"_"+DatoFormularioRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DatoFormularioRentaConstantesFunciones.SCHEMA+"_"+DatoFormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DatoFormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DatoFormularioRentaConstantesFunciones.SCHEMA+"_"+DatoFormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoFormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoFormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoFormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DatoFormularioRentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DatoFormularioRentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DatoFormularioRentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DatoFormularioRentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dato Formulario Rentas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dato Formulario Renta";
	public static final String SCLASSWEBTITULO_LOWER="Dato Formulario Renta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DatoFormularioRenta";
	public static final String OBJECTNAME="datoformulariorenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="dato_formulario_renta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select datoformulariorenta from "+DatoFormularioRentaConstantesFunciones.SPERSISTENCENAME+" datoformulariorenta";
	public static String QUERYSELECTNATIVE="select "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".version_row,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id_anio,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id_mes,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".es_sustitutiva,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".numero_formulario,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".cedula_representante,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".numero_fiscal from "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME;//+" as "+DatoFormularioRentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DatoFormularioRentaConstantesFuncionesAdditional datoformulariorentaConstantesFuncionesAdditional=null;
	
	public DatoFormularioRentaConstantesFuncionesAdditional getDatoFormularioRentaConstantesFuncionesAdditional() {
		return this.datoformulariorentaConstantesFuncionesAdditional;
	}
	
	public void setDatoFormularioRentaConstantesFuncionesAdditional(DatoFormularioRentaConstantesFuncionesAdditional datoformulariorentaConstantesFuncionesAdditional) {
		try {
			this.datoformulariorentaConstantesFuncionesAdditional=datoformulariorentaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String ESSUSTITUTIVA= "es_sustitutiva";
    public static final String NUMEROFORMULARIO= "numero_formulario";
    public static final String CEDULAREPRESENTANTE= "cedula_representante";
    public static final String NUMEROFISCAL= "numero_fiscal";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_ESSUSTITUTIVA= "Es Sustitutiva";
		public static final String LABEL_ESSUSTITUTIVA_LOWER= "Es Sustitutiva";
    	public static final String LABEL_NUMEROFORMULARIO= "Numero Formulario";
		public static final String LABEL_NUMEROFORMULARIO_LOWER= "Numero Formulario";
    	public static final String LABEL_CEDULAREPRESENTANTE= "Cedula Representante";
		public static final String LABEL_CEDULAREPRESENTANTE_LOWER= "Cedula Representante";
    	public static final String LABEL_NUMEROFISCAL= "Numero Fiscal";
		public static final String LABEL_NUMEROFISCAL_LOWER= "Numero Fiscal";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_FORMULARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FORMULARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCEDULA_REPRESENTANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCEDULA_REPRESENTANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FISCAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FISCAL=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDatoFormularioRentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DatoFormularioRentaConstantesFunciones.IDANIO)) {sLabelColumna=DatoFormularioRentaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DatoFormularioRentaConstantesFunciones.IDMES)) {sLabelColumna=DatoFormularioRentaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA)) {sLabelColumna=DatoFormularioRentaConstantesFunciones.LABEL_ESSUSTITUTIVA;}
		if(sNombreColumna.equals(DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO)) {sLabelColumna=DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFORMULARIO;}
		if(sNombreColumna.equals(DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE)) {sLabelColumna=DatoFormularioRentaConstantesFunciones.LABEL_CEDULAREPRESENTANTE;}
		if(sNombreColumna.equals(DatoFormularioRentaConstantesFunciones.NUMEROFISCAL)) {sLabelColumna=DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFISCAL;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_sustitutivaDescripcion(DatoFormularioRenta datoformulariorenta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datoformulariorenta.getes_sustitutiva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_sustitutivaHtmlDescripcion(DatoFormularioRenta datoformulariorenta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datoformulariorenta.getId(),datoformulariorenta.getes_sustitutiva());

		return sDescripcion;
	}	
			
			
			
	
	public static String getDatoFormularioRentaDescripcion(DatoFormularioRenta datoformulariorenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(datoformulariorenta !=null/* && datoformulariorenta.getId()!=0*/) {
			if(datoformulariorenta.getId()!=null) {
				sDescripcion=datoformulariorenta.getId().toString();
			}//datoformulariorentadatoformulariorenta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDatoFormularioRentaDescripcionDetallado(DatoFormularioRenta datoformulariorenta) {
		String sDescripcion="";
			
		sDescripcion+=DatoFormularioRentaConstantesFunciones.ID+"=";
		sDescripcion+=datoformulariorenta.getId().toString()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=datoformulariorenta.getVersionRow().toString()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.IDANIO+"=";
		sDescripcion+=datoformulariorenta.getid_anio().toString()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.IDMES+"=";
		sDescripcion+=datoformulariorenta.getid_mes().toString()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA+"=";
		sDescripcion+=datoformulariorenta.getes_sustitutiva().toString()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO+"=";
		sDescripcion+=datoformulariorenta.getnumero_formulario()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE+"=";
		sDescripcion+=datoformulariorenta.getcedula_representante()+",";
		sDescripcion+=DatoFormularioRentaConstantesFunciones.NUMEROFISCAL+"=";
		sDescripcion+=datoformulariorenta.getnumero_fiscal()+",";
			
		return sDescripcion;
	}
	
	public static void setDatoFormularioRentaDescripcion(DatoFormularioRenta datoformulariorenta,String sValor) throws Exception {			
		if(datoformulariorenta !=null) {
			//datoformulariorentadatoformulariorenta.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosDatoFormularioRenta(DatoFormularioRenta datoformulariorenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		datoformulariorenta.setnumero_formulario(datoformulariorenta.getnumero_formulario().trim());
		datoformulariorenta.setcedula_representante(datoformulariorenta.getcedula_representante().trim());
		datoformulariorenta.setnumero_fiscal(datoformulariorenta.getnumero_fiscal().trim());
	}
	
	public static void quitarEspaciosDatoFormularioRentas(List<DatoFormularioRenta> datoformulariorentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DatoFormularioRenta datoformulariorenta: datoformulariorentas) {
			datoformulariorenta.setnumero_formulario(datoformulariorenta.getnumero_formulario().trim());
			datoformulariorenta.setcedula_representante(datoformulariorenta.getcedula_representante().trim());
			datoformulariorenta.setnumero_fiscal(datoformulariorenta.getnumero_fiscal().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoFormularioRenta(DatoFormularioRenta datoformulariorenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && datoformulariorenta.getConCambioAuxiliar()) {
			datoformulariorenta.setIsDeleted(datoformulariorenta.getIsDeletedAuxiliar());	
			datoformulariorenta.setIsNew(datoformulariorenta.getIsNewAuxiliar());	
			datoformulariorenta.setIsChanged(datoformulariorenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			datoformulariorenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			datoformulariorenta.setIsDeletedAuxiliar(false);	
			datoformulariorenta.setIsNewAuxiliar(false);	
			datoformulariorenta.setIsChangedAuxiliar(false);
			
			datoformulariorenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoFormularioRentas(List<DatoFormularioRenta> datoformulariorentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DatoFormularioRenta datoformulariorenta : datoformulariorentas) {
			if(conAsignarBase && datoformulariorenta.getConCambioAuxiliar()) {
				datoformulariorenta.setIsDeleted(datoformulariorenta.getIsDeletedAuxiliar());	
				datoformulariorenta.setIsNew(datoformulariorenta.getIsNewAuxiliar());	
				datoformulariorenta.setIsChanged(datoformulariorenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				datoformulariorenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				datoformulariorenta.setIsDeletedAuxiliar(false);	
				datoformulariorenta.setIsNewAuxiliar(false);	
				datoformulariorenta.setIsChangedAuxiliar(false);
				
				datoformulariorenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDatoFormularioRenta(DatoFormularioRenta datoformulariorenta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDatoFormularioRentas(List<DatoFormularioRenta> datoformulariorentas,Boolean conEnteros) throws Exception  {
		
		for(DatoFormularioRenta datoformulariorenta: datoformulariorentas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDatoFormularioRenta(List<DatoFormularioRenta> datoformulariorentas,DatoFormularioRenta datoformulariorentaAux) throws Exception  {
		DatoFormularioRentaConstantesFunciones.InicializarValoresDatoFormularioRenta(datoformulariorentaAux,true);
		
		for(DatoFormularioRenta datoformulariorenta: datoformulariorentas) {
			if(datoformulariorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoFormularioRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DatoFormularioRentaConstantesFunciones.getArrayColumnasGlobalesDatoFormularioRenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoFormularioRenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDatoFormularioRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DatoFormularioRenta> datoformulariorentas,DatoFormularioRenta datoformulariorenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DatoFormularioRenta datoformulariorentaAux: datoformulariorentas) {
			if(datoformulariorentaAux!=null && datoformulariorenta!=null) {
				if((datoformulariorentaAux.getId()==null && datoformulariorenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(datoformulariorentaAux.getId()!=null && datoformulariorenta.getId()!=null){
					if(datoformulariorentaAux.getId().equals(datoformulariorenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDatoFormularioRenta(List<DatoFormularioRenta> datoformulariorentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DatoFormularioRenta datoformulariorenta: datoformulariorentas) {			
			if(datoformulariorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDatoFormularioRenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_ID, DatoFormularioRentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_VERSIONROW, DatoFormularioRentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_IDANIO, DatoFormularioRentaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_IDMES, DatoFormularioRentaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_ESSUSTITUTIVA, DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFORMULARIO, DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_CEDULAREPRESENTANTE, DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFISCAL, DatoFormularioRentaConstantesFunciones.NUMEROFISCAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDatoFormularioRenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoFormularioRentaConstantesFunciones.NUMEROFISCAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoFormularioRenta() throws Exception  {
		return DatoFormularioRentaConstantesFunciones.getTiposSeleccionarDatoFormularioRenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoFormularioRenta(Boolean conFk) throws Exception  {
		return DatoFormularioRentaConstantesFunciones.getTiposSeleccionarDatoFormularioRenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoFormularioRenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioRentaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DatoFormularioRentaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioRentaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DatoFormularioRentaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioRentaConstantesFunciones.LABEL_ESSUSTITUTIVA);
			reporte.setsDescripcion(DatoFormularioRentaConstantesFunciones.LABEL_ESSUSTITUTIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFORMULARIO);
			reporte.setsDescripcion(DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFORMULARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioRentaConstantesFunciones.LABEL_CEDULAREPRESENTANTE);
			reporte.setsDescripcion(DatoFormularioRentaConstantesFunciones.LABEL_CEDULAREPRESENTANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFISCAL);
			reporte.setsDescripcion(DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFISCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDatoFormularioRenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDatoFormularioRenta(DatoFormularioRenta datoformulariorentaAux) throws Exception {
		
			datoformulariorentaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(datoformulariorentaAux.getAnio()));
			datoformulariorentaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(datoformulariorentaAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDatoFormularioRenta(List<DatoFormularioRenta> datoformulariorentasTemp) throws Exception {
		for(DatoFormularioRenta datoformulariorentaAux:datoformulariorentasTemp) {
			
			datoformulariorentaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(datoformulariorentaAux.getAnio()));
			datoformulariorentaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(datoformulariorentaAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDatoFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDatoFormularioRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoFormularioRentaConstantesFunciones.getClassesRelationshipsOfDatoFormularioRenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormularioRenta.class));
				classes.add(new Classe(FormularioRentaExtra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioRenta.class)) {
						classes.add(new Classe(FormularioRenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioRentaExtra.class)) {
						classes.add(new Classe(FormularioRentaExtra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoFormularioRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoFormularioRentaConstantesFunciones.getClassesRelationshipsFromStringsOfDatoFormularioRenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoFormularioRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRenta.class)); continue;
					}

					if(FormularioRentaExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRentaExtra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormularioRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRenta.class)); continue;
					}

					if(FormularioRentaExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioRentaExtra.class)); continue;
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
	public static void actualizarLista(DatoFormularioRenta datoformulariorenta,List<DatoFormularioRenta> datoformulariorentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DatoFormularioRenta datoformulariorentaEncontrado=null;
			
			for(DatoFormularioRenta datoformulariorentaLocal:datoformulariorentas) {
				if(datoformulariorentaLocal.getId().equals(datoformulariorenta.getId())) {
					datoformulariorentaEncontrado=datoformulariorentaLocal;
					
					datoformulariorentaLocal.setIsChanged(datoformulariorenta.getIsChanged());
					datoformulariorentaLocal.setIsNew(datoformulariorenta.getIsNew());
					datoformulariorentaLocal.setIsDeleted(datoformulariorenta.getIsDeleted());
					
					datoformulariorentaLocal.setGeneralEntityOriginal(datoformulariorenta.getGeneralEntityOriginal());
					
					datoformulariorentaLocal.setId(datoformulariorenta.getId());	
					datoformulariorentaLocal.setVersionRow(datoformulariorenta.getVersionRow());	
					datoformulariorentaLocal.setid_anio(datoformulariorenta.getid_anio());	
					datoformulariorentaLocal.setid_mes(datoformulariorenta.getid_mes());	
					datoformulariorentaLocal.setes_sustitutiva(datoformulariorenta.getes_sustitutiva());	
					datoformulariorentaLocal.setnumero_formulario(datoformulariorenta.getnumero_formulario());	
					datoformulariorentaLocal.setcedula_representante(datoformulariorenta.getcedula_representante());	
					datoformulariorentaLocal.setnumero_fiscal(datoformulariorenta.getnumero_fiscal());	
					
					
					datoformulariorentaLocal.setFormularioRentas(datoformulariorenta.getFormularioRentas());
					datoformulariorentaLocal.setFormularioRentaExtras(datoformulariorenta.getFormularioRentaExtras());
					
					existe=true;
					break;
				}
			}
			
			if(!datoformulariorenta.getIsDeleted()) {
				if(!existe) {
					datoformulariorentas.add(datoformulariorenta);
				}
			} else {
				if(datoformulariorentaEncontrado!=null && permiteQuitar)  {
					datoformulariorentas.remove(datoformulariorentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DatoFormularioRenta datoformulariorenta,List<DatoFormularioRenta> datoformulariorentas) throws Exception {
		try	{			
			for(DatoFormularioRenta datoformulariorentaLocal:datoformulariorentas) {
				if(datoformulariorentaLocal.getId().equals(datoformulariorenta.getId())) {
					datoformulariorentaLocal.setIsSelected(datoformulariorenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDatoFormularioRenta(List<DatoFormularioRenta> datoformulariorentasAux) throws Exception {
		//this.datoformulariorentasAux=datoformulariorentasAux;
		
		for(DatoFormularioRenta datoformulariorentaAux:datoformulariorentasAux) {
			if(datoformulariorentaAux.getIsChanged()) {
				datoformulariorentaAux.setIsChanged(false);
			}		
			
			if(datoformulariorentaAux.getIsNew()) {
				datoformulariorentaAux.setIsNew(false);
			}	
			
			if(datoformulariorentaAux.getIsDeleted()) {
				datoformulariorentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDatoFormularioRenta(DatoFormularioRenta datoformulariorentaAux) throws Exception {
		//this.datoformulariorentaAux=datoformulariorentaAux;
		
			if(datoformulariorentaAux.getIsChanged()) {
				datoformulariorentaAux.setIsChanged(false);
			}		
			
			if(datoformulariorentaAux.getIsNew()) {
				datoformulariorentaAux.setIsNew(false);
			}	
			
			if(datoformulariorentaAux.getIsDeleted()) {
				datoformulariorentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DatoFormularioRenta datoformulariorentaAsignar,DatoFormularioRenta datoformulariorenta) throws Exception {
		datoformulariorentaAsignar.setId(datoformulariorenta.getId());	
		datoformulariorentaAsignar.setVersionRow(datoformulariorenta.getVersionRow());	
		datoformulariorentaAsignar.setid_anio(datoformulariorenta.getid_anio());
		datoformulariorentaAsignar.setanio_descripcion(datoformulariorenta.getanio_descripcion());	
		datoformulariorentaAsignar.setid_mes(datoformulariorenta.getid_mes());
		datoformulariorentaAsignar.setmes_descripcion(datoformulariorenta.getmes_descripcion());	
		datoformulariorentaAsignar.setes_sustitutiva(datoformulariorenta.getes_sustitutiva());	
		datoformulariorentaAsignar.setnumero_formulario(datoformulariorenta.getnumero_formulario());	
		datoformulariorentaAsignar.setcedula_representante(datoformulariorenta.getcedula_representante());	
		datoformulariorentaAsignar.setnumero_fiscal(datoformulariorenta.getnumero_fiscal());	
	}
	
	public static void inicializarDatoFormularioRenta(DatoFormularioRenta datoformulariorenta) throws Exception {
		try {
				datoformulariorenta.setId(0L);	
					
				datoformulariorenta.setid_anio(null);	
				datoformulariorenta.setid_mes(null);	
				datoformulariorenta.setes_sustitutiva(false);	
				datoformulariorenta.setnumero_formulario("");	
				datoformulariorenta.setcedula_representante("");	
				datoformulariorenta.setnumero_fiscal("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDatoFormularioRenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioRentaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioRentaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioRentaConstantesFunciones.LABEL_ESSUSTITUTIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFORMULARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioRentaConstantesFunciones.LABEL_CEDULAREPRESENTANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoFormularioRentaConstantesFunciones.LABEL_NUMEROFISCAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDatoFormularioRenta(String sTipo,Row row,Workbook workbook,DatoFormularioRenta datoformulariorenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformulariorenta.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformulariorenta.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datoformulariorenta.getes_sustitutiva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformulariorenta.getnumero_formulario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformulariorenta.getcedula_representante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoformulariorenta.getnumero_fiscal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDatoFormularioRenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDatoFormularioRenta() {
		return this.sFinalQueryDatoFormularioRenta;
	}
	
	public void setsFinalQueryDatoFormularioRenta(String sFinalQueryDatoFormularioRenta) {
		this.sFinalQueryDatoFormularioRenta= sFinalQueryDatoFormularioRenta;
	}
	
	public Border resaltarSeleccionarDatoFormularioRenta=null;
	
	public Border setResaltarSeleccionarDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDatoFormularioRenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDatoFormularioRenta() {
		return this.resaltarSeleccionarDatoFormularioRenta;
	}
	
	public void setResaltarSeleccionarDatoFormularioRenta(Border borderResaltarSeleccionarDatoFormularioRenta) {
		this.resaltarSeleccionarDatoFormularioRenta= borderResaltarSeleccionarDatoFormularioRenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDatoFormularioRenta=null;
	public Boolean mostraridDatoFormularioRenta=true;
	public Boolean activaridDatoFormularioRenta=true;

	public Border resaltarid_anioDatoFormularioRenta=null;
	public Boolean mostrarid_anioDatoFormularioRenta=true;
	public Boolean activarid_anioDatoFormularioRenta=true;
	public Boolean cargarid_anioDatoFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDatoFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_mesDatoFormularioRenta=null;
	public Boolean mostrarid_mesDatoFormularioRenta=true;
	public Boolean activarid_mesDatoFormularioRenta=true;
	public Boolean cargarid_mesDatoFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDatoFormularioRenta=false;//ConEventDepend=true

	public Border resaltares_sustitutivaDatoFormularioRenta=null;
	public Boolean mostrares_sustitutivaDatoFormularioRenta=true;
	public Boolean activares_sustitutivaDatoFormularioRenta=true;

	public Border resaltarnumero_formularioDatoFormularioRenta=null;
	public Boolean mostrarnumero_formularioDatoFormularioRenta=true;
	public Boolean activarnumero_formularioDatoFormularioRenta=true;

	public Border resaltarcedula_representanteDatoFormularioRenta=null;
	public Boolean mostrarcedula_representanteDatoFormularioRenta=true;
	public Boolean activarcedula_representanteDatoFormularioRenta=true;

	public Border resaltarnumero_fiscalDatoFormularioRenta=null;
	public Boolean mostrarnumero_fiscalDatoFormularioRenta=true;
	public Boolean activarnumero_fiscalDatoFormularioRenta=true;

	
	

	public Border setResaltaridDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltaridDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDatoFormularioRenta() {
		return this.resaltaridDatoFormularioRenta;
	}

	public void setResaltaridDatoFormularioRenta(Border borderResaltar) {
		this.resaltaridDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostraridDatoFormularioRenta() {
		return this.mostraridDatoFormularioRenta;
	}

	public void setMostraridDatoFormularioRenta(Boolean mostraridDatoFormularioRenta) {
		this.mostraridDatoFormularioRenta= mostraridDatoFormularioRenta;
	}

	public Boolean getActivaridDatoFormularioRenta() {
		return this.activaridDatoFormularioRenta;
	}

	public void setActivaridDatoFormularioRenta(Boolean activaridDatoFormularioRenta) {
		this.activaridDatoFormularioRenta= activaridDatoFormularioRenta;
	}

	public Border setResaltarid_anioDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_anioDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDatoFormularioRenta() {
		return this.resaltarid_anioDatoFormularioRenta;
	}

	public void setResaltarid_anioDatoFormularioRenta(Border borderResaltar) {
		this.resaltarid_anioDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_anioDatoFormularioRenta() {
		return this.mostrarid_anioDatoFormularioRenta;
	}

	public void setMostrarid_anioDatoFormularioRenta(Boolean mostrarid_anioDatoFormularioRenta) {
		this.mostrarid_anioDatoFormularioRenta= mostrarid_anioDatoFormularioRenta;
	}

	public Boolean getActivarid_anioDatoFormularioRenta() {
		return this.activarid_anioDatoFormularioRenta;
	}

	public void setActivarid_anioDatoFormularioRenta(Boolean activarid_anioDatoFormularioRenta) {
		this.activarid_anioDatoFormularioRenta= activarid_anioDatoFormularioRenta;
	}

	public Boolean getCargarid_anioDatoFormularioRenta() {
		return this.cargarid_anioDatoFormularioRenta;
	}

	public void setCargarid_anioDatoFormularioRenta(Boolean cargarid_anioDatoFormularioRenta) {
		this.cargarid_anioDatoFormularioRenta= cargarid_anioDatoFormularioRenta;
	}

	public Border setResaltarid_mesDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_mesDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDatoFormularioRenta() {
		return this.resaltarid_mesDatoFormularioRenta;
	}

	public void setResaltarid_mesDatoFormularioRenta(Border borderResaltar) {
		this.resaltarid_mesDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_mesDatoFormularioRenta() {
		return this.mostrarid_mesDatoFormularioRenta;
	}

	public void setMostrarid_mesDatoFormularioRenta(Boolean mostrarid_mesDatoFormularioRenta) {
		this.mostrarid_mesDatoFormularioRenta= mostrarid_mesDatoFormularioRenta;
	}

	public Boolean getActivarid_mesDatoFormularioRenta() {
		return this.activarid_mesDatoFormularioRenta;
	}

	public void setActivarid_mesDatoFormularioRenta(Boolean activarid_mesDatoFormularioRenta) {
		this.activarid_mesDatoFormularioRenta= activarid_mesDatoFormularioRenta;
	}

	public Boolean getCargarid_mesDatoFormularioRenta() {
		return this.cargarid_mesDatoFormularioRenta;
	}

	public void setCargarid_mesDatoFormularioRenta(Boolean cargarid_mesDatoFormularioRenta) {
		this.cargarid_mesDatoFormularioRenta= cargarid_mesDatoFormularioRenta;
	}

	public Border setResaltares_sustitutivaDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltares_sustitutivaDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_sustitutivaDatoFormularioRenta() {
		return this.resaltares_sustitutivaDatoFormularioRenta;
	}

	public void setResaltares_sustitutivaDatoFormularioRenta(Border borderResaltar) {
		this.resaltares_sustitutivaDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrares_sustitutivaDatoFormularioRenta() {
		return this.mostrares_sustitutivaDatoFormularioRenta;
	}

	public void setMostrares_sustitutivaDatoFormularioRenta(Boolean mostrares_sustitutivaDatoFormularioRenta) {
		this.mostrares_sustitutivaDatoFormularioRenta= mostrares_sustitutivaDatoFormularioRenta;
	}

	public Boolean getActivares_sustitutivaDatoFormularioRenta() {
		return this.activares_sustitutivaDatoFormularioRenta;
	}

	public void setActivares_sustitutivaDatoFormularioRenta(Boolean activares_sustitutivaDatoFormularioRenta) {
		this.activares_sustitutivaDatoFormularioRenta= activares_sustitutivaDatoFormularioRenta;
	}

	public Border setResaltarnumero_formularioDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarnumero_formularioDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_formularioDatoFormularioRenta() {
		return this.resaltarnumero_formularioDatoFormularioRenta;
	}

	public void setResaltarnumero_formularioDatoFormularioRenta(Border borderResaltar) {
		this.resaltarnumero_formularioDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarnumero_formularioDatoFormularioRenta() {
		return this.mostrarnumero_formularioDatoFormularioRenta;
	}

	public void setMostrarnumero_formularioDatoFormularioRenta(Boolean mostrarnumero_formularioDatoFormularioRenta) {
		this.mostrarnumero_formularioDatoFormularioRenta= mostrarnumero_formularioDatoFormularioRenta;
	}

	public Boolean getActivarnumero_formularioDatoFormularioRenta() {
		return this.activarnumero_formularioDatoFormularioRenta;
	}

	public void setActivarnumero_formularioDatoFormularioRenta(Boolean activarnumero_formularioDatoFormularioRenta) {
		this.activarnumero_formularioDatoFormularioRenta= activarnumero_formularioDatoFormularioRenta;
	}

	public Border setResaltarcedula_representanteDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarcedula_representanteDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcedula_representanteDatoFormularioRenta() {
		return this.resaltarcedula_representanteDatoFormularioRenta;
	}

	public void setResaltarcedula_representanteDatoFormularioRenta(Border borderResaltar) {
		this.resaltarcedula_representanteDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarcedula_representanteDatoFormularioRenta() {
		return this.mostrarcedula_representanteDatoFormularioRenta;
	}

	public void setMostrarcedula_representanteDatoFormularioRenta(Boolean mostrarcedula_representanteDatoFormularioRenta) {
		this.mostrarcedula_representanteDatoFormularioRenta= mostrarcedula_representanteDatoFormularioRenta;
	}

	public Boolean getActivarcedula_representanteDatoFormularioRenta() {
		return this.activarcedula_representanteDatoFormularioRenta;
	}

	public void setActivarcedula_representanteDatoFormularioRenta(Boolean activarcedula_representanteDatoFormularioRenta) {
		this.activarcedula_representanteDatoFormularioRenta= activarcedula_representanteDatoFormularioRenta;
	}

	public Border setResaltarnumero_fiscalDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarnumero_fiscalDatoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_fiscalDatoFormularioRenta() {
		return this.resaltarnumero_fiscalDatoFormularioRenta;
	}

	public void setResaltarnumero_fiscalDatoFormularioRenta(Border borderResaltar) {
		this.resaltarnumero_fiscalDatoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarnumero_fiscalDatoFormularioRenta() {
		return this.mostrarnumero_fiscalDatoFormularioRenta;
	}

	public void setMostrarnumero_fiscalDatoFormularioRenta(Boolean mostrarnumero_fiscalDatoFormularioRenta) {
		this.mostrarnumero_fiscalDatoFormularioRenta= mostrarnumero_fiscalDatoFormularioRenta;
	}

	public Boolean getActivarnumero_fiscalDatoFormularioRenta() {
		return this.activarnumero_fiscalDatoFormularioRenta;
	}

	public void setActivarnumero_fiscalDatoFormularioRenta(Boolean activarnumero_fiscalDatoFormularioRenta) {
		this.activarnumero_fiscalDatoFormularioRenta= activarnumero_fiscalDatoFormularioRenta;
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
		
		
		this.setMostraridDatoFormularioRenta(esInicial);
		this.setMostrarid_anioDatoFormularioRenta(esInicial);
		this.setMostrarid_mesDatoFormularioRenta(esInicial);
		this.setMostrares_sustitutivaDatoFormularioRenta(esInicial);
		this.setMostrarnumero_formularioDatoFormularioRenta(esInicial);
		this.setMostrarcedula_representanteDatoFormularioRenta(esInicial);
		this.setMostrarnumero_fiscalDatoFormularioRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.ID)) {
				this.setMostraridDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA)) {
				this.setMostrares_sustitutivaDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO)) {
				this.setMostrarnumero_formularioDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE)) {
				this.setMostrarcedula_representanteDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.NUMEROFISCAL)) {
				this.setMostrarnumero_fiscalDatoFormularioRenta(esAsigna);
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
		
		
		this.setActivaridDatoFormularioRenta(esInicial);
		this.setActivarid_anioDatoFormularioRenta(esInicial);
		this.setActivarid_mesDatoFormularioRenta(esInicial);
		this.setActivares_sustitutivaDatoFormularioRenta(esInicial);
		this.setActivarnumero_formularioDatoFormularioRenta(esInicial);
		this.setActivarcedula_representanteDatoFormularioRenta(esInicial);
		this.setActivarnumero_fiscalDatoFormularioRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.ID)) {
				this.setActivaridDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.IDMES)) {
				this.setActivarid_mesDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA)) {
				this.setActivares_sustitutivaDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO)) {
				this.setActivarnumero_formularioDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE)) {
				this.setActivarcedula_representanteDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.NUMEROFISCAL)) {
				this.setActivarnumero_fiscalDatoFormularioRenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDatoFormularioRenta(esInicial);
		this.setResaltarid_anioDatoFormularioRenta(esInicial);
		this.setResaltarid_mesDatoFormularioRenta(esInicial);
		this.setResaltares_sustitutivaDatoFormularioRenta(esInicial);
		this.setResaltarnumero_formularioDatoFormularioRenta(esInicial);
		this.setResaltarcedula_representanteDatoFormularioRenta(esInicial);
		this.setResaltarnumero_fiscalDatoFormularioRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.ID)) {
				this.setResaltaridDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA)) {
				this.setResaltares_sustitutivaDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO)) {
				this.setResaltarnumero_formularioDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE)) {
				this.setResaltarcedula_representanteDatoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoFormularioRentaConstantesFunciones.NUMEROFISCAL)) {
				this.setResaltarnumero_fiscalDatoFormularioRenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormularioRentaDatoFormularioRenta=null;

	public Border getResaltarFormularioRentaDatoFormularioRenta() {
		return this.resaltarFormularioRentaDatoFormularioRenta;
	}

	public void setResaltarFormularioRentaDatoFormularioRenta(Border borderResaltarFormularioRenta) {
		if(borderResaltarFormularioRenta!=null) {
			this.resaltarFormularioRentaDatoFormularioRenta= borderResaltarFormularioRenta;
		}
	}

	public Border setResaltarFormularioRentaDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioRenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltarFormularioRenta);
			
		this.resaltarFormularioRentaDatoFormularioRenta= borderResaltarFormularioRenta;

		 return borderResaltarFormularioRenta;
	}



	public Boolean mostrarFormularioRentaDatoFormularioRenta=true;

	public Boolean getMostrarFormularioRentaDatoFormularioRenta() {
		return this.mostrarFormularioRentaDatoFormularioRenta;
	}

	public void setMostrarFormularioRentaDatoFormularioRenta(Boolean visibilidadResaltarFormularioRenta) {
		this.mostrarFormularioRentaDatoFormularioRenta= visibilidadResaltarFormularioRenta;
	}



	public Boolean activarFormularioRentaDatoFormularioRenta=true;

	public Boolean gethabilitarResaltarFormularioRentaDatoFormularioRenta() {
		return this.activarFormularioRentaDatoFormularioRenta;
	}

	public void setActivarFormularioRentaDatoFormularioRenta(Boolean habilitarResaltarFormularioRenta) {
		this.activarFormularioRentaDatoFormularioRenta= habilitarResaltarFormularioRenta;
	}


	public Border resaltarFormularioRentaExtraDatoFormularioRenta=null;

	public Border getResaltarFormularioRentaExtraDatoFormularioRenta() {
		return this.resaltarFormularioRentaExtraDatoFormularioRenta;
	}

	public void setResaltarFormularioRentaExtraDatoFormularioRenta(Border borderResaltarFormularioRentaExtra) {
		if(borderResaltarFormularioRentaExtra!=null) {
			this.resaltarFormularioRentaExtraDatoFormularioRenta= borderResaltarFormularioRentaExtra;
		}
	}

	public Border setResaltarFormularioRentaExtraDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioRentaExtra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//datoformulariorentaBeanSwingJInternalFrame.jTtoolBarDatoFormularioRenta.setBorder(borderResaltarFormularioRentaExtra);
			
		this.resaltarFormularioRentaExtraDatoFormularioRenta= borderResaltarFormularioRentaExtra;

		 return borderResaltarFormularioRentaExtra;
	}



	public Boolean mostrarFormularioRentaExtraDatoFormularioRenta=true;

	public Boolean getMostrarFormularioRentaExtraDatoFormularioRenta() {
		return this.mostrarFormularioRentaExtraDatoFormularioRenta;
	}

	public void setMostrarFormularioRentaExtraDatoFormularioRenta(Boolean visibilidadResaltarFormularioRentaExtra) {
		this.mostrarFormularioRentaExtraDatoFormularioRenta= visibilidadResaltarFormularioRentaExtra;
	}



	public Boolean activarFormularioRentaExtraDatoFormularioRenta=true;

	public Boolean gethabilitarResaltarFormularioRentaExtraDatoFormularioRenta() {
		return this.activarFormularioRentaExtraDatoFormularioRenta;
	}

	public void setActivarFormularioRentaExtraDatoFormularioRenta(Boolean habilitarResaltarFormularioRentaExtra) {
		this.activarFormularioRentaExtraDatoFormularioRenta= habilitarResaltarFormularioRentaExtra;
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

		this.setMostrarFormularioRentaDatoFormularioRenta(esInicial);
		this.setMostrarFormularioRentaExtraDatoFormularioRenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRenta.class)) {
				this.setMostrarFormularioRentaDatoFormularioRenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioRentaExtra.class)) {
				this.setMostrarFormularioRentaExtraDatoFormularioRenta(esAsigna);
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

		this.setActivarFormularioRentaDatoFormularioRenta(esInicial);
		this.setActivarFormularioRentaExtraDatoFormularioRenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRenta.class)) {
				this.setActivarFormularioRentaDatoFormularioRenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioRentaExtra.class)) {
				this.setActivarFormularioRentaExtraDatoFormularioRenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormularioRentaDatoFormularioRenta(esInicial);
		this.setResaltarFormularioRentaExtraDatoFormularioRenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormularioRenta.class)) {
				this.setResaltarFormularioRentaDatoFormularioRenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioRentaExtra.class)) {
				this.setResaltarFormularioRentaExtraDatoFormularioRenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAnioDatoFormularioRenta=true;

	public Boolean getMostrarFK_IdAnioDatoFormularioRenta() {
		return this.mostrarFK_IdAnioDatoFormularioRenta;
	}

	public void setMostrarFK_IdAnioDatoFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioDatoFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesDatoFormularioRenta=true;

	public Boolean getMostrarFK_IdMesDatoFormularioRenta() {
		return this.mostrarFK_IdMesDatoFormularioRenta;
	}

	public void setMostrarFK_IdMesDatoFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesDatoFormularioRenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioDatoFormularioRenta=true;

	public Boolean getActivarFK_IdAnioDatoFormularioRenta() {
		return this.activarFK_IdAnioDatoFormularioRenta;
	}

	public void setActivarFK_IdAnioDatoFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdAnioDatoFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdMesDatoFormularioRenta=true;

	public Boolean getActivarFK_IdMesDatoFormularioRenta() {
		return this.activarFK_IdMesDatoFormularioRenta;
	}

	public void setActivarFK_IdMesDatoFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdMesDatoFormularioRenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioDatoFormularioRenta=null;

	public Border getResaltarFK_IdAnioDatoFormularioRenta() {
		return this.resaltarFK_IdAnioDatoFormularioRenta;
	}

	public void setResaltarFK_IdAnioDatoFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdAnioDatoFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdAnioDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioDatoFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdMesDatoFormularioRenta=null;

	public Border getResaltarFK_IdMesDatoFormularioRenta() {
		return this.resaltarFK_IdMesDatoFormularioRenta;
	}

	public void setResaltarFK_IdMesDatoFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdMesDatoFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdMesDatoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*DatoFormularioRentaBeanSwingJInternalFrame datoformulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesDatoFormularioRenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}