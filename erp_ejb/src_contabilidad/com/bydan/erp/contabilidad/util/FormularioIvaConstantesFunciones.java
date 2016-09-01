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


import com.bydan.erp.contabilidad.util.FormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormularioIvaParameterGeneral;

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
final public class FormularioIvaConstantesFunciones extends FormularioIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormularioIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormularioIva"+FormularioIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormularioIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormularioIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormularioIvaConstantesFunciones.SCHEMA+"_"+FormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormularioIvaConstantesFunciones.SCHEMA+"_"+FormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormularioIvaConstantesFunciones.SCHEMA+"_"+FormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormularioIvaConstantesFunciones.SCHEMA+"_"+FormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormularioIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormularioIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formulario Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formulario Iva";
	public static final String SCLASSWEBTITULO_LOWER="Formulario Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormularioIva";
	public static final String OBJECTNAME="formularioiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="formulario_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formularioiva from "+FormularioIvaConstantesFunciones.SPERSISTENCENAME+" formularioiva";
	public static String QUERYSELECTNATIVE="select "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".version_row,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_periodo,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_dato_formulario_iva,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_grupo_parametro_formulario_iva,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_parametro_formulario_iva,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".valor from "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME;//+" as "+FormularioIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormularioIvaConstantesFuncionesAdditional formularioivaConstantesFuncionesAdditional=null;
	
	public FormularioIvaConstantesFuncionesAdditional getFormularioIvaConstantesFuncionesAdditional() {
		return this.formularioivaConstantesFuncionesAdditional;
	}
	
	public void setFormularioIvaConstantesFuncionesAdditional(FormularioIvaConstantesFuncionesAdditional formularioivaConstantesFuncionesAdditional) {
		try {
			this.formularioivaConstantesFuncionesAdditional=formularioivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDDATOFORMULARIOIVA= "id_dato_formulario_iva";
    public static final String IDGRUPOPARAMETROFORMULARIOIVA= "id_grupo_parametro_formulario_iva";
    public static final String IDPARAMETROFORMULARIOIVA= "id_parametro_formulario_iva";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDDATOFORMULARIOIVA= "Dato Formulario Iva";
		public static final String LABEL_IDDATOFORMULARIOIVA_LOWER= "Dato Formulario Iva";
    	public static final String LABEL_IDGRUPOPARAMETROFORMULARIOIVA= "Grupo Parametro Formulario Iva";
		public static final String LABEL_IDGRUPOPARAMETROFORMULARIOIVA_LOWER= "Grupo Parametro Formulario Iva";
    	public static final String LABEL_IDPARAMETROFORMULARIOIVA= "Parametro Formulario Iva";
		public static final String LABEL_IDPARAMETROFORMULARIOIVA_LOWER= "Parametro Formulario Iva";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
		
		
	
	public static String getFormularioIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.IDPERIODO)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_IDDATOFORMULARIOIVA;}
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA;}
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA;}
		if(sNombreColumna.equals(FormularioIvaConstantesFunciones.VALOR)) {sLabelColumna=FormularioIvaConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getFormularioIvaDescripcion(FormularioIva formularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formularioiva !=null/* && formularioiva.getId()!=0*/) {
			if(formularioiva.getId()!=null) {
				sDescripcion=formularioiva.getId().toString();
			}//formularioivaformularioiva.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormularioIvaDescripcionDetallado(FormularioIva formularioiva) {
		String sDescripcion="";
			
		sDescripcion+=FormularioIvaConstantesFunciones.ID+"=";
		sDescripcion+=formularioiva.getId().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formularioiva.getVersionRow().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formularioiva.getid_empresa().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formularioiva.getid_ejercicio().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=formularioiva.getid_periodo().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA+"=";
		sDescripcion+=formularioiva.getid_dato_formulario_iva().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA+"=";
		sDescripcion+=formularioiva.getid_grupo_parametro_formulario_iva().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA+"=";
		sDescripcion+=formularioiva.getid_parametro_formulario_iva().toString()+",";
		sDescripcion+=FormularioIvaConstantesFunciones.VALOR+"=";
		sDescripcion+=formularioiva.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormularioIvaDescripcion(FormularioIva formularioiva,String sValor) throws Exception {			
		if(formularioiva !=null) {
			//formularioivaformularioiva.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getDatoFormularioIvaDescripcion(DatoFormularioIva datoformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(datoformularioiva!=null/*&&datoformularioiva.getId()>0*/) {
			sDescripcion=DatoFormularioIvaConstantesFunciones.getDatoFormularioIvaDescripcion(datoformularioiva);
		}

		return sDescripcion;
	}

	public static String getGrupoParametroFormularioIvaDescripcion(GrupoParametroFormularioIva grupoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupoparametroformularioiva!=null/*&&grupoparametroformularioiva.getId()>0*/) {
			sDescripcion=GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaDescripcion(grupoparametroformularioiva);
		}

		return sDescripcion;
	}

	public static String getParametroFormularioIvaDescripcion(ParametroFormularioIva parametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(parametroformularioiva!=null/*&&parametroformularioiva.getId()>0*/) {
			sDescripcion=ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(parametroformularioiva);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorDatoFormularioPorGrupo")) {
			sNombreIndice="Tipo=  Por Dato Formulario Iva Por Grupo Parametro Formulario Iva";
		} else if(sNombreIndice.equals("FK_IdDatoFormularioIva")) {
			sNombreIndice="Tipo=  Por Dato Formulario Iva";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoParametroFormularioIva")) {
			sNombreIndice="Tipo=  Por Grupo Parametro Formulario Iva";
		} else if(sNombreIndice.equals("FK_IdParametroFormularioIva")) {
			sNombreIndice="Tipo=  Por Parametro Formulario Iva";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorDatoFormularioPorGrupo(Long id_dato_formulario_iva,Long id_grupo_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_dato_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Dato Formulario Iva="+id_dato_formulario_iva.toString();}
		if(id_grupo_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Grupo Parametro Formulario Iva="+id_grupo_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDatoFormularioIva(Long id_dato_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_dato_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Dato Formulario Iva="+id_dato_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoParametroFormularioIva(Long id_grupo_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Grupo Parametro Formulario Iva="+id_grupo_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdParametroFormularioIva(Long id_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Parametro Formulario Iva="+id_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormularioIva(FormularioIva formularioiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosFormularioIvas(List<FormularioIva> formularioivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormularioIva formularioiva: formularioivas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioIva(FormularioIva formularioiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formularioiva.getConCambioAuxiliar()) {
			formularioiva.setIsDeleted(formularioiva.getIsDeletedAuxiliar());	
			formularioiva.setIsNew(formularioiva.getIsNewAuxiliar());	
			formularioiva.setIsChanged(formularioiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formularioiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formularioiva.setIsDeletedAuxiliar(false);	
			formularioiva.setIsNewAuxiliar(false);	
			formularioiva.setIsChangedAuxiliar(false);
			
			formularioiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioIvas(List<FormularioIva> formularioivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormularioIva formularioiva : formularioivas) {
			if(conAsignarBase && formularioiva.getConCambioAuxiliar()) {
				formularioiva.setIsDeleted(formularioiva.getIsDeletedAuxiliar());	
				formularioiva.setIsNew(formularioiva.getIsNewAuxiliar());	
				formularioiva.setIsChanged(formularioiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formularioiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formularioiva.setIsDeletedAuxiliar(false);	
				formularioiva.setIsNewAuxiliar(false);	
				formularioiva.setIsChangedAuxiliar(false);
				
				formularioiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormularioIva(FormularioIva formularioiva,Boolean conEnteros) throws Exception  {
		formularioiva.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormularioIvas(List<FormularioIva> formularioivas,Boolean conEnteros) throws Exception  {
		
		for(FormularioIva formularioiva: formularioivas) {
			formularioiva.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormularioIva(List<FormularioIva> formularioivas,FormularioIva formularioivaAux) throws Exception  {
		FormularioIvaConstantesFunciones.InicializarValoresFormularioIva(formularioivaAux,true);
		
		for(FormularioIva formularioiva: formularioivas) {
			if(formularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formularioivaAux.setvalor(formularioivaAux.getvalor()+formularioiva.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormularioIvaConstantesFunciones.getArrayColumnasGlobalesFormularioIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioIvaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioIvaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioIvaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioIvaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioIvaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioIvaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormularioIva> formularioivas,FormularioIva formularioiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormularioIva formularioivaAux: formularioivas) {
			if(formularioivaAux!=null && formularioiva!=null) {
				if((formularioivaAux.getId()==null && formularioiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formularioivaAux.getId()!=null && formularioiva.getId()!=null){
					if(formularioivaAux.getId().equals(formularioiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormularioIva(List<FormularioIva> formularioivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(FormularioIva formularioiva: formularioivas) {			
			if(formularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=formularioiva.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioIvaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormularioIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_ID, FormularioIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_VERSIONROW, FormularioIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_IDEMPRESA, FormularioIvaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_IDEJERCICIO, FormularioIvaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_IDPERIODO, FormularioIvaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_IDDATOFORMULARIOIVA, FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA, FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA, FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioIvaConstantesFunciones.LABEL_VALOR, FormularioIvaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormularioIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioIvaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioIva() throws Exception  {
		return FormularioIvaConstantesFunciones.getTiposSeleccionarFormularioIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioIva(Boolean conFk) throws Exception  {
		return FormularioIvaConstantesFunciones.getTiposSeleccionarFormularioIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_IDDATOFORMULARIOIVA);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_IDDATOFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioIvaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(FormularioIvaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormularioIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioIva(FormularioIva formularioivaAux) throws Exception {
		
			formularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formularioivaAux.getEmpresa()));
			formularioivaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formularioivaAux.getEjercicio()));
			formularioivaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formularioivaAux.getPeriodo()));
			formularioivaAux.setdatoformularioiva_descripcion(DatoFormularioIvaConstantesFunciones.getDatoFormularioIvaDescripcion(formularioivaAux.getDatoFormularioIva()));
			formularioivaAux.setgrupoparametroformularioiva_descripcion(GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaDescripcion(formularioivaAux.getGrupoParametroFormularioIva()));
			formularioivaAux.setparametroformularioiva_descripcion(ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(formularioivaAux.getParametroFormularioIva()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioIva(List<FormularioIva> formularioivasTemp) throws Exception {
		for(FormularioIva formularioivaAux:formularioivasTemp) {
			
			formularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formularioivaAux.getEmpresa()));
			formularioivaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formularioivaAux.getEjercicio()));
			formularioivaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formularioivaAux.getPeriodo()));
			formularioivaAux.setdatoformularioiva_descripcion(DatoFormularioIvaConstantesFunciones.getDatoFormularioIvaDescripcion(formularioivaAux.getDatoFormularioIva()));
			formularioivaAux.setgrupoparametroformularioiva_descripcion(GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaDescripcion(formularioivaAux.getGrupoParametroFormularioIva()));
			formularioivaAux.setparametroformularioiva_descripcion(ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(formularioivaAux.getParametroFormularioIva()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(DatoFormularioIva.class));
				classes.add(new Classe(GrupoParametroFormularioIva.class));
				classes.add(new Classe(ParametroFormularioIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoFormularioIva.class)) {
						classes.add(new Classe(DatoFormularioIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
						classes.add(new Classe(GrupoParametroFormularioIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFormularioIva.class)) {
						classes.add(new Classe(ParametroFormularioIva.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(DatoFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoFormularioIva.class)); continue;
					}

					if(GrupoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoParametroFormularioIva.class)); continue;
					}

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(DatoFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoFormularioIva.class)); continue;
					}

					if(GrupoParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoParametroFormularioIva.class)); continue;
					}

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioIvaConstantesFunciones.getClassesRelationshipsOfFormularioIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioIvaConstantesFunciones.getClassesRelationshipsFromStringsOfFormularioIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FormularioIva formularioiva,List<FormularioIva> formularioivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormularioIva formularioivaEncontrado=null;
			
			for(FormularioIva formularioivaLocal:formularioivas) {
				if(formularioivaLocal.getId().equals(formularioiva.getId())) {
					formularioivaEncontrado=formularioivaLocal;
					
					formularioivaLocal.setIsChanged(formularioiva.getIsChanged());
					formularioivaLocal.setIsNew(formularioiva.getIsNew());
					formularioivaLocal.setIsDeleted(formularioiva.getIsDeleted());
					
					formularioivaLocal.setGeneralEntityOriginal(formularioiva.getGeneralEntityOriginal());
					
					formularioivaLocal.setId(formularioiva.getId());	
					formularioivaLocal.setVersionRow(formularioiva.getVersionRow());	
					formularioivaLocal.setid_empresa(formularioiva.getid_empresa());	
					formularioivaLocal.setid_ejercicio(formularioiva.getid_ejercicio());	
					formularioivaLocal.setid_periodo(formularioiva.getid_periodo());	
					formularioivaLocal.setid_dato_formulario_iva(formularioiva.getid_dato_formulario_iva());	
					formularioivaLocal.setid_grupo_parametro_formulario_iva(formularioiva.getid_grupo_parametro_formulario_iva());	
					formularioivaLocal.setid_parametro_formulario_iva(formularioiva.getid_parametro_formulario_iva());	
					formularioivaLocal.setvalor(formularioiva.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formularioiva.getIsDeleted()) {
				if(!existe) {
					formularioivas.add(formularioiva);
				}
			} else {
				if(formularioivaEncontrado!=null && permiteQuitar)  {
					formularioivas.remove(formularioivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormularioIva formularioiva,List<FormularioIva> formularioivas) throws Exception {
		try	{			
			for(FormularioIva formularioivaLocal:formularioivas) {
				if(formularioivaLocal.getId().equals(formularioiva.getId())) {
					formularioivaLocal.setIsSelected(formularioiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormularioIva(List<FormularioIva> formularioivasAux) throws Exception {
		//this.formularioivasAux=formularioivasAux;
		
		for(FormularioIva formularioivaAux:formularioivasAux) {
			if(formularioivaAux.getIsChanged()) {
				formularioivaAux.setIsChanged(false);
			}		
			
			if(formularioivaAux.getIsNew()) {
				formularioivaAux.setIsNew(false);
			}	
			
			if(formularioivaAux.getIsDeleted()) {
				formularioivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormularioIva(FormularioIva formularioivaAux) throws Exception {
		//this.formularioivaAux=formularioivaAux;
		
			if(formularioivaAux.getIsChanged()) {
				formularioivaAux.setIsChanged(false);
			}		
			
			if(formularioivaAux.getIsNew()) {
				formularioivaAux.setIsNew(false);
			}	
			
			if(formularioivaAux.getIsDeleted()) {
				formularioivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormularioIva formularioivaAsignar,FormularioIva formularioiva) throws Exception {
		formularioivaAsignar.setId(formularioiva.getId());	
		formularioivaAsignar.setVersionRow(formularioiva.getVersionRow());	
		formularioivaAsignar.setid_empresa(formularioiva.getid_empresa());
		formularioivaAsignar.setempresa_descripcion(formularioiva.getempresa_descripcion());	
		formularioivaAsignar.setid_ejercicio(formularioiva.getid_ejercicio());
		formularioivaAsignar.setejercicio_descripcion(formularioiva.getejercicio_descripcion());	
		formularioivaAsignar.setid_periodo(formularioiva.getid_periodo());
		formularioivaAsignar.setperiodo_descripcion(formularioiva.getperiodo_descripcion());	
		formularioivaAsignar.setid_dato_formulario_iva(formularioiva.getid_dato_formulario_iva());
		formularioivaAsignar.setdatoformularioiva_descripcion(formularioiva.getdatoformularioiva_descripcion());	
		formularioivaAsignar.setid_grupo_parametro_formulario_iva(formularioiva.getid_grupo_parametro_formulario_iva());
		formularioivaAsignar.setgrupoparametroformularioiva_descripcion(formularioiva.getgrupoparametroformularioiva_descripcion());	
		formularioivaAsignar.setid_parametro_formulario_iva(formularioiva.getid_parametro_formulario_iva());
		formularioivaAsignar.setparametroformularioiva_descripcion(formularioiva.getparametroformularioiva_descripcion());	
		formularioivaAsignar.setvalor(formularioiva.getvalor());	
	}
	
	public static void inicializarFormularioIva(FormularioIva formularioiva) throws Exception {
		try {
				formularioiva.setId(0L);	
					
				formularioiva.setid_empresa(-1L);	
				formularioiva.setid_ejercicio(-1L);	
				formularioiva.setid_periodo(-1L);	
				formularioiva.setid_dato_formulario_iva(-1L);	
				formularioiva.setid_grupo_parametro_formulario_iva(-1L);	
				formularioiva.setid_parametro_formulario_iva(-1L);	
				formularioiva.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormularioIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_IDDATOFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_IDGRUPOPARAMETROFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioIvaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormularioIva(String sTipo,Row row,Workbook workbook,FormularioIva formularioiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getdatoformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getgrupoparametroformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getparametroformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formularioiva.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormularioIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormularioIva() {
		return this.sFinalQueryFormularioIva;
	}
	
	public void setsFinalQueryFormularioIva(String sFinalQueryFormularioIva) {
		this.sFinalQueryFormularioIva= sFinalQueryFormularioIva;
	}
	
	public Border resaltarSeleccionarFormularioIva=null;
	
	public Border setResaltarSeleccionarFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormularioIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormularioIva() {
		return this.resaltarSeleccionarFormularioIva;
	}
	
	public void setResaltarSeleccionarFormularioIva(Border borderResaltarSeleccionarFormularioIva) {
		this.resaltarSeleccionarFormularioIva= borderResaltarSeleccionarFormularioIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormularioIva=null;
	public Boolean mostraridFormularioIva=true;
	public Boolean activaridFormularioIva=true;

	public Border resaltarid_empresaFormularioIva=null;
	public Boolean mostrarid_empresaFormularioIva=true;
	public Boolean activarid_empresaFormularioIva=true;
	public Boolean cargarid_empresaFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormularioIva=null;
	public Boolean mostrarid_ejercicioFormularioIva=true;
	public Boolean activarid_ejercicioFormularioIva=true;
	public Boolean cargarid_ejercicioFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_periodoFormularioIva=null;
	public Boolean mostrarid_periodoFormularioIva=true;
	public Boolean activarid_periodoFormularioIva=true;
	public Boolean cargarid_periodoFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_dato_formulario_ivaFormularioIva=null;
	public Boolean mostrarid_dato_formulario_ivaFormularioIva=true;
	public Boolean activarid_dato_formulario_ivaFormularioIva=true;
	public Boolean cargarid_dato_formulario_ivaFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_dato_formulario_ivaFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_grupo_parametro_formulario_ivaFormularioIva=null;
	public Boolean mostrarid_grupo_parametro_formulario_ivaFormularioIva=true;
	public Boolean activarid_grupo_parametro_formulario_ivaFormularioIva=true;
	public Boolean cargarid_grupo_parametro_formulario_ivaFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_parametro_formulario_ivaFormularioIva=false;//ConEventDepend=true

	public Border resaltarid_parametro_formulario_ivaFormularioIva=null;
	public Boolean mostrarid_parametro_formulario_ivaFormularioIva=true;
	public Boolean activarid_parametro_formulario_ivaFormularioIva=true;
	public Boolean cargarid_parametro_formulario_ivaFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parametro_formulario_ivaFormularioIva=false;//ConEventDepend=true

	public Border resaltarvalorFormularioIva=null;
	public Boolean mostrarvalorFormularioIva=true;
	public Boolean activarvalorFormularioIva=true;

	
	

	public Border setResaltaridFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltaridFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormularioIva() {
		return this.resaltaridFormularioIva;
	}

	public void setResaltaridFormularioIva(Border borderResaltar) {
		this.resaltaridFormularioIva= borderResaltar;
	}

	public Boolean getMostraridFormularioIva() {
		return this.mostraridFormularioIva;
	}

	public void setMostraridFormularioIva(Boolean mostraridFormularioIva) {
		this.mostraridFormularioIva= mostraridFormularioIva;
	}

	public Boolean getActivaridFormularioIva() {
		return this.activaridFormularioIva;
	}

	public void setActivaridFormularioIva(Boolean activaridFormularioIva) {
		this.activaridFormularioIva= activaridFormularioIva;
	}

	public Border setResaltarid_empresaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormularioIva() {
		return this.resaltarid_empresaFormularioIva;
	}

	public void setResaltarid_empresaFormularioIva(Border borderResaltar) {
		this.resaltarid_empresaFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormularioIva() {
		return this.mostrarid_empresaFormularioIva;
	}

	public void setMostrarid_empresaFormularioIva(Boolean mostrarid_empresaFormularioIva) {
		this.mostrarid_empresaFormularioIva= mostrarid_empresaFormularioIva;
	}

	public Boolean getActivarid_empresaFormularioIva() {
		return this.activarid_empresaFormularioIva;
	}

	public void setActivarid_empresaFormularioIva(Boolean activarid_empresaFormularioIva) {
		this.activarid_empresaFormularioIva= activarid_empresaFormularioIva;
	}

	public Boolean getCargarid_empresaFormularioIva() {
		return this.cargarid_empresaFormularioIva;
	}

	public void setCargarid_empresaFormularioIva(Boolean cargarid_empresaFormularioIva) {
		this.cargarid_empresaFormularioIva= cargarid_empresaFormularioIva;
	}

	public Border setResaltarid_ejercicioFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormularioIva() {
		return this.resaltarid_ejercicioFormularioIva;
	}

	public void setResaltarid_ejercicioFormularioIva(Border borderResaltar) {
		this.resaltarid_ejercicioFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormularioIva() {
		return this.mostrarid_ejercicioFormularioIva;
	}

	public void setMostrarid_ejercicioFormularioIva(Boolean mostrarid_ejercicioFormularioIva) {
		this.mostrarid_ejercicioFormularioIva= mostrarid_ejercicioFormularioIva;
	}

	public Boolean getActivarid_ejercicioFormularioIva() {
		return this.activarid_ejercicioFormularioIva;
	}

	public void setActivarid_ejercicioFormularioIva(Boolean activarid_ejercicioFormularioIva) {
		this.activarid_ejercicioFormularioIva= activarid_ejercicioFormularioIva;
	}

	public Boolean getCargarid_ejercicioFormularioIva() {
		return this.cargarid_ejercicioFormularioIva;
	}

	public void setCargarid_ejercicioFormularioIva(Boolean cargarid_ejercicioFormularioIva) {
		this.cargarid_ejercicioFormularioIva= cargarid_ejercicioFormularioIva;
	}

	public Border setResaltarid_periodoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_periodoFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFormularioIva() {
		return this.resaltarid_periodoFormularioIva;
	}

	public void setResaltarid_periodoFormularioIva(Border borderResaltar) {
		this.resaltarid_periodoFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_periodoFormularioIva() {
		return this.mostrarid_periodoFormularioIva;
	}

	public void setMostrarid_periodoFormularioIva(Boolean mostrarid_periodoFormularioIva) {
		this.mostrarid_periodoFormularioIva= mostrarid_periodoFormularioIva;
	}

	public Boolean getActivarid_periodoFormularioIva() {
		return this.activarid_periodoFormularioIva;
	}

	public void setActivarid_periodoFormularioIva(Boolean activarid_periodoFormularioIva) {
		this.activarid_periodoFormularioIva= activarid_periodoFormularioIva;
	}

	public Boolean getCargarid_periodoFormularioIva() {
		return this.cargarid_periodoFormularioIva;
	}

	public void setCargarid_periodoFormularioIva(Boolean cargarid_periodoFormularioIva) {
		this.cargarid_periodoFormularioIva= cargarid_periodoFormularioIva;
	}

	public Border setResaltarid_dato_formulario_ivaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_dato_formulario_ivaFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_dato_formulario_ivaFormularioIva() {
		return this.resaltarid_dato_formulario_ivaFormularioIva;
	}

	public void setResaltarid_dato_formulario_ivaFormularioIva(Border borderResaltar) {
		this.resaltarid_dato_formulario_ivaFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_dato_formulario_ivaFormularioIva() {
		return this.mostrarid_dato_formulario_ivaFormularioIva;
	}

	public void setMostrarid_dato_formulario_ivaFormularioIva(Boolean mostrarid_dato_formulario_ivaFormularioIva) {
		this.mostrarid_dato_formulario_ivaFormularioIva= mostrarid_dato_formulario_ivaFormularioIva;
	}

	public Boolean getActivarid_dato_formulario_ivaFormularioIva() {
		return this.activarid_dato_formulario_ivaFormularioIva;
	}

	public void setActivarid_dato_formulario_ivaFormularioIva(Boolean activarid_dato_formulario_ivaFormularioIva) {
		this.activarid_dato_formulario_ivaFormularioIva= activarid_dato_formulario_ivaFormularioIva;
	}

	public Boolean getCargarid_dato_formulario_ivaFormularioIva() {
		return this.cargarid_dato_formulario_ivaFormularioIva;
	}

	public void setCargarid_dato_formulario_ivaFormularioIva(Boolean cargarid_dato_formulario_ivaFormularioIva) {
		this.cargarid_dato_formulario_ivaFormularioIva= cargarid_dato_formulario_ivaFormularioIva;
	}

	public Border setResaltarid_grupo_parametro_formulario_ivaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_grupo_parametro_formulario_ivaFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_parametro_formulario_ivaFormularioIva() {
		return this.resaltarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public void setResaltarid_grupo_parametro_formulario_ivaFormularioIva(Border borderResaltar) {
		this.resaltarid_grupo_parametro_formulario_ivaFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_grupo_parametro_formulario_ivaFormularioIva() {
		return this.mostrarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public void setMostrarid_grupo_parametro_formulario_ivaFormularioIva(Boolean mostrarid_grupo_parametro_formulario_ivaFormularioIva) {
		this.mostrarid_grupo_parametro_formulario_ivaFormularioIva= mostrarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public Boolean getActivarid_grupo_parametro_formulario_ivaFormularioIva() {
		return this.activarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public void setActivarid_grupo_parametro_formulario_ivaFormularioIva(Boolean activarid_grupo_parametro_formulario_ivaFormularioIva) {
		this.activarid_grupo_parametro_formulario_ivaFormularioIva= activarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public Boolean getCargarid_grupo_parametro_formulario_ivaFormularioIva() {
		return this.cargarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public void setCargarid_grupo_parametro_formulario_ivaFormularioIva(Boolean cargarid_grupo_parametro_formulario_ivaFormularioIva) {
		this.cargarid_grupo_parametro_formulario_ivaFormularioIva= cargarid_grupo_parametro_formulario_ivaFormularioIva;
	}

	public Border setResaltarid_parametro_formulario_ivaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_parametro_formulario_ivaFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parametro_formulario_ivaFormularioIva() {
		return this.resaltarid_parametro_formulario_ivaFormularioIva;
	}

	public void setResaltarid_parametro_formulario_ivaFormularioIva(Border borderResaltar) {
		this.resaltarid_parametro_formulario_ivaFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_parametro_formulario_ivaFormularioIva() {
		return this.mostrarid_parametro_formulario_ivaFormularioIva;
	}

	public void setMostrarid_parametro_formulario_ivaFormularioIva(Boolean mostrarid_parametro_formulario_ivaFormularioIva) {
		this.mostrarid_parametro_formulario_ivaFormularioIva= mostrarid_parametro_formulario_ivaFormularioIva;
	}

	public Boolean getActivarid_parametro_formulario_ivaFormularioIva() {
		return this.activarid_parametro_formulario_ivaFormularioIva;
	}

	public void setActivarid_parametro_formulario_ivaFormularioIva(Boolean activarid_parametro_formulario_ivaFormularioIva) {
		this.activarid_parametro_formulario_ivaFormularioIva= activarid_parametro_formulario_ivaFormularioIva;
	}

	public Boolean getCargarid_parametro_formulario_ivaFormularioIva() {
		return this.cargarid_parametro_formulario_ivaFormularioIva;
	}

	public void setCargarid_parametro_formulario_ivaFormularioIva(Boolean cargarid_parametro_formulario_ivaFormularioIva) {
		this.cargarid_parametro_formulario_ivaFormularioIva= cargarid_parametro_formulario_ivaFormularioIva;
	}

	public Border setResaltarvalorFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formularioivaBeanSwingJInternalFrame.jTtoolBarFormularioIva.setBorder(borderResaltar);
		
		this.resaltarvalorFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorFormularioIva() {
		return this.resaltarvalorFormularioIva;
	}

	public void setResaltarvalorFormularioIva(Border borderResaltar) {
		this.resaltarvalorFormularioIva= borderResaltar;
	}

	public Boolean getMostrarvalorFormularioIva() {
		return this.mostrarvalorFormularioIva;
	}

	public void setMostrarvalorFormularioIva(Boolean mostrarvalorFormularioIva) {
		this.mostrarvalorFormularioIva= mostrarvalorFormularioIva;
	}

	public Boolean getActivarvalorFormularioIva() {
		return this.activarvalorFormularioIva;
	}

	public void setActivarvalorFormularioIva(Boolean activarvalorFormularioIva) {
		this.activarvalorFormularioIva= activarvalorFormularioIva;
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
		
		
		this.setMostraridFormularioIva(esInicial);
		this.setMostrarid_empresaFormularioIva(esInicial);
		this.setMostrarid_ejercicioFormularioIva(esInicial);
		this.setMostrarid_periodoFormularioIva(esInicial);
		this.setMostrarid_dato_formulario_ivaFormularioIva(esInicial);
		this.setMostrarid_grupo_parametro_formulario_ivaFormularioIva(esInicial);
		this.setMostrarid_parametro_formulario_ivaFormularioIva(esInicial);
		this.setMostrarvalorFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioIvaConstantesFunciones.ID)) {
				this.setMostraridFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA)) {
				this.setMostrarid_dato_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {
				this.setMostrarid_grupo_parametro_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {
				this.setMostrarid_parametro_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.VALOR)) {
				this.setMostrarvalorFormularioIva(esAsigna);
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
		
		
		this.setActivaridFormularioIva(esInicial);
		this.setActivarid_empresaFormularioIva(esInicial);
		this.setActivarid_ejercicioFormularioIva(esInicial);
		this.setActivarid_periodoFormularioIva(esInicial);
		this.setActivarid_dato_formulario_ivaFormularioIva(esInicial);
		this.setActivarid_grupo_parametro_formulario_ivaFormularioIva(esInicial);
		this.setActivarid_parametro_formulario_ivaFormularioIva(esInicial);
		this.setActivarvalorFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioIvaConstantesFunciones.ID)) {
				this.setActivaridFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA)) {
				this.setActivarid_dato_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {
				this.setActivarid_grupo_parametro_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {
				this.setActivarid_parametro_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.VALOR)) {
				this.setActivarvalorFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormularioIva(esInicial);
		this.setResaltarid_empresaFormularioIva(esInicial);
		this.setResaltarid_ejercicioFormularioIva(esInicial);
		this.setResaltarid_periodoFormularioIva(esInicial);
		this.setResaltarid_dato_formulario_ivaFormularioIva(esInicial);
		this.setResaltarid_grupo_parametro_formulario_ivaFormularioIva(esInicial);
		this.setResaltarid_parametro_formulario_ivaFormularioIva(esInicial);
		this.setResaltarvalorFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioIvaConstantesFunciones.ID)) {
				this.setResaltaridFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA)) {
				this.setResaltarid_dato_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA)) {
				this.setResaltarid_grupo_parametro_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {
				this.setResaltarid_parametro_formulario_ivaFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioIvaConstantesFunciones.VALOR)) {
				this.setResaltarvalorFormularioIva(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorDatoFormularioPorGrupoFormularioIva=true;

	public Boolean getMostrarBusquedaPorDatoFormularioPorGrupoFormularioIva() {
		return this.mostrarBusquedaPorDatoFormularioPorGrupoFormularioIva;
	}

	public void setMostrarBusquedaPorDatoFormularioPorGrupoFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorDatoFormularioPorGrupoFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDatoFormularioIvaFormularioIva=true;

	public Boolean getMostrarFK_IdDatoFormularioIvaFormularioIva() {
		return this.mostrarFK_IdDatoFormularioIvaFormularioIva;
	}

	public void setMostrarFK_IdDatoFormularioIvaFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDatoFormularioIvaFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFormularioIva=true;

	public Boolean getMostrarFK_IdEjercicioFormularioIva() {
		return this.mostrarFK_IdEjercicioFormularioIva;
	}

	public void setMostrarFK_IdEjercicioFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormularioIva=true;

	public Boolean getMostrarFK_IdEmpresaFormularioIva() {
		return this.mostrarFK_IdEmpresaFormularioIva;
	}

	public void setMostrarFK_IdEmpresaFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoParametroFormularioIvaFormularioIva=true;

	public Boolean getMostrarFK_IdGrupoParametroFormularioIvaFormularioIva() {
		return this.mostrarFK_IdGrupoParametroFormularioIvaFormularioIva;
	}

	public void setMostrarFK_IdGrupoParametroFormularioIvaFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoParametroFormularioIvaFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParametroFormularioIvaFormularioIva=true;

	public Boolean getMostrarFK_IdParametroFormularioIvaFormularioIva() {
		return this.mostrarFK_IdParametroFormularioIvaFormularioIva;
	}

	public void setMostrarFK_IdParametroFormularioIvaFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParametroFormularioIvaFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFormularioIva=true;

	public Boolean getMostrarFK_IdPeriodoFormularioIva() {
		return this.mostrarFK_IdPeriodoFormularioIva;
	}

	public void setMostrarFK_IdPeriodoFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFormularioIva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorDatoFormularioPorGrupoFormularioIva=true;

	public Boolean getActivarBusquedaPorDatoFormularioPorGrupoFormularioIva() {
		return this.activarBusquedaPorDatoFormularioPorGrupoFormularioIva;
	}

	public void setActivarBusquedaPorDatoFormularioPorGrupoFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorDatoFormularioPorGrupoFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdDatoFormularioIvaFormularioIva=true;

	public Boolean getActivarFK_IdDatoFormularioIvaFormularioIva() {
		return this.activarFK_IdDatoFormularioIvaFormularioIva;
	}

	public void setActivarFK_IdDatoFormularioIvaFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdDatoFormularioIvaFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFormularioIva=true;

	public Boolean getActivarFK_IdEjercicioFormularioIva() {
		return this.activarFK_IdEjercicioFormularioIva;
	}

	public void setActivarFK_IdEjercicioFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormularioIva=true;

	public Boolean getActivarFK_IdEmpresaFormularioIva() {
		return this.activarFK_IdEmpresaFormularioIva;
	}

	public void setActivarFK_IdEmpresaFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoParametroFormularioIvaFormularioIva=true;

	public Boolean getActivarFK_IdGrupoParametroFormularioIvaFormularioIva() {
		return this.activarFK_IdGrupoParametroFormularioIvaFormularioIva;
	}

	public void setActivarFK_IdGrupoParametroFormularioIvaFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoParametroFormularioIvaFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdParametroFormularioIvaFormularioIva=true;

	public Boolean getActivarFK_IdParametroFormularioIvaFormularioIva() {
		return this.activarFK_IdParametroFormularioIvaFormularioIva;
	}

	public void setActivarFK_IdParametroFormularioIvaFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdParametroFormularioIvaFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFormularioIva=true;

	public Boolean getActivarFK_IdPeriodoFormularioIva() {
		return this.activarFK_IdPeriodoFormularioIva;
	}

	public void setActivarFK_IdPeriodoFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFormularioIva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorDatoFormularioPorGrupoFormularioIva=null;

	public Border getResaltarBusquedaPorDatoFormularioPorGrupoFormularioIva() {
		return this.resaltarBusquedaPorDatoFormularioPorGrupoFormularioIva;
	}

	public void setResaltarBusquedaPorDatoFormularioPorGrupoFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorDatoFormularioPorGrupoFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorDatoFormularioPorGrupoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorDatoFormularioPorGrupoFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdDatoFormularioIvaFormularioIva=null;

	public Border getResaltarFK_IdDatoFormularioIvaFormularioIva() {
		return this.resaltarFK_IdDatoFormularioIvaFormularioIva;
	}

	public void setResaltarFK_IdDatoFormularioIvaFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdDatoFormularioIvaFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdDatoFormularioIvaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDatoFormularioIvaFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFormularioIva=null;

	public Border getResaltarFK_IdEjercicioFormularioIva() {
		return this.resaltarFK_IdEjercicioFormularioIva;
	}

	public void setResaltarFK_IdEjercicioFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormularioIva=null;

	public Border getResaltarFK_IdEmpresaFormularioIva() {
		return this.resaltarFK_IdEmpresaFormularioIva;
	}

	public void setResaltarFK_IdEmpresaFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdGrupoParametroFormularioIvaFormularioIva=null;

	public Border getResaltarFK_IdGrupoParametroFormularioIvaFormularioIva() {
		return this.resaltarFK_IdGrupoParametroFormularioIvaFormularioIva;
	}

	public void setResaltarFK_IdGrupoParametroFormularioIvaFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdGrupoParametroFormularioIvaFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdGrupoParametroFormularioIvaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoParametroFormularioIvaFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdParametroFormularioIvaFormularioIva=null;

	public Border getResaltarFK_IdParametroFormularioIvaFormularioIva() {
		return this.resaltarFK_IdParametroFormularioIvaFormularioIva;
	}

	public void setResaltarFK_IdParametroFormularioIvaFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdParametroFormularioIvaFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdParametroFormularioIvaFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParametroFormularioIvaFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFormularioIva=null;

	public Border getResaltarFK_IdPeriodoFormularioIva() {
		return this.resaltarFK_IdPeriodoFormularioIva;
	}

	public void setResaltarFK_IdPeriodoFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioIvaBeanSwingJInternalFrame formularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFormularioIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}