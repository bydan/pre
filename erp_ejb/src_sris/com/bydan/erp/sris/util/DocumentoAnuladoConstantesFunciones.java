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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.DocumentoAnuladoConstantesFunciones;
import com.bydan.erp.sris.util.DocumentoAnuladoParameterReturnGeneral;
//import com.bydan.erp.sris.util.DocumentoAnuladoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DocumentoAnuladoConstantesFunciones extends DocumentoAnuladoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DocumentoAnulado";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DocumentoAnulado"+DocumentoAnuladoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DocumentoAnuladoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DocumentoAnuladoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DocumentoAnuladoConstantesFunciones.SCHEMA+"_"+DocumentoAnuladoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DocumentoAnuladoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DocumentoAnuladoConstantesFunciones.SCHEMA+"_"+DocumentoAnuladoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DocumentoAnuladoConstantesFunciones.SCHEMA+"_"+DocumentoAnuladoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DocumentoAnuladoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DocumentoAnuladoConstantesFunciones.SCHEMA+"_"+DocumentoAnuladoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DocumentoAnuladoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DocumentoAnuladoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DocumentoAnuladoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DocumentoAnuladoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DocumentoAnuladoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DocumentoAnuladoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DocumentoAnuladoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DocumentoAnuladoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DocumentoAnuladoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DocumentoAnuladoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Documento Anulados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Documento Anulado";
	public static final String SCLASSWEBTITULO_LOWER="Documento Anulado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DocumentoAnulado";
	public static final String OBJECTNAME="documentoanulado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="documento_anulado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select documentoanulado from "+DocumentoAnuladoConstantesFunciones.SPERSISTENCENAME+" documentoanulado";
	public static String QUERYSELECTNATIVE="select "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".version_row,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_empresa,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_periodo_declara,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_modulo,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".numero,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".serie,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".autorizacion,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".fecha_anulacion from "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME;//+" as "+DocumentoAnuladoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DocumentoAnuladoConstantesFuncionesAdditional documentoanuladoConstantesFuncionesAdditional=null;
	
	public DocumentoAnuladoConstantesFuncionesAdditional getDocumentoAnuladoConstantesFuncionesAdditional() {
		return this.documentoanuladoConstantesFuncionesAdditional;
	}
	
	public void setDocumentoAnuladoConstantesFuncionesAdditional(DocumentoAnuladoConstantesFuncionesAdditional documentoanuladoConstantesFuncionesAdditional) {
		try {
			this.documentoanuladoConstantesFuncionesAdditional=documentoanuladoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPERIODODECLARA= "id_periodo_declara";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOCOMPROBANTE= "id_tipo_comprobante";
    public static final String NUMERO= "numero";
    public static final String SERIE= "serie";
    public static final String AUTORIZACION= "autorizacion";
    public static final String FECHAANULACION= "fecha_anulacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPERIODODECLARA= "Periodo Declara";
		public static final String LABEL_IDPERIODODECLARA_LOWER= "Periodo Declara";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOCOMPROBANTE= "Tipo Comprobante";
		public static final String LABEL_IDTIPOCOMPROBANTE_LOWER= "Tipo Comprobante";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_AUTORIZACION= "Autorizacion";
		public static final String LABEL_AUTORIZACION_LOWER= "Autorizacion";
    	public static final String LABEL_FECHAANULACION= "Fecha Anulacion";
		public static final String LABEL_FECHAANULACION_LOWER= "Fecha Anulacion";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDocumentoAnuladoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_IDPERIODODECLARA;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.IDMODULO)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_IDTIPOCOMPROBANTE;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.NUMERO)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.SERIE)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.AUTORIZACION)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_AUTORIZACION;}
		if(sNombreColumna.equals(DocumentoAnuladoConstantesFunciones.FECHAANULACION)) {sLabelColumna=DocumentoAnuladoConstantesFunciones.LABEL_FECHAANULACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getDocumentoAnuladoDescripcion(DocumentoAnulado documentoanulado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(documentoanulado !=null/* && documentoanulado.getId()!=0*/) {
			if(documentoanulado.getId()!=null) {
				sDescripcion=documentoanulado.getId().toString();
			}//documentoanuladodocumentoanulado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDocumentoAnuladoDescripcionDetallado(DocumentoAnulado documentoanulado) {
		String sDescripcion="";
			
		sDescripcion+=DocumentoAnuladoConstantesFunciones.ID+"=";
		sDescripcion+=documentoanulado.getId().toString()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=documentoanulado.getVersionRow().toString()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=documentoanulado.getid_empresa().toString()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA+"=";
		sDescripcion+=documentoanulado.getid_periodo_declara().toString()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=documentoanulado.getid_modulo().toString()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE+"=";
		sDescripcion+=documentoanulado.getid_tipo_comprobante().toString()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.NUMERO+"=";
		sDescripcion+=documentoanulado.getnumero()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.SERIE+"=";
		sDescripcion+=documentoanulado.getserie()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.AUTORIZACION+"=";
		sDescripcion+=documentoanulado.getautorizacion()+",";
		sDescripcion+=DocumentoAnuladoConstantesFunciones.FECHAANULACION+"=";
		sDescripcion+=documentoanulado.getfecha_anulacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDocumentoAnuladoDescripcion(DocumentoAnulado documentoanulado,String sValor) throws Exception {			
		if(documentoanulado !=null) {
			//documentoanuladodocumentoanulado.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periododeclara!=null/*&&periododeclara.getId()>0*/) {
			sDescripcion=PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(periododeclara);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoComprobanteDescripcion(TipoComprobante tipocomprobante) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocomprobante!=null/*&&tipocomprobante.getId()>0*/) {
			sDescripcion=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(tipocomprobante);
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
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPeriodoDeclara")) {
			sNombreIndice="Tipo=  Por Periodo Declara";
		} else if(sNombreIndice.equals("FK_IdTipoComprobante")) {
			sNombreIndice="Tipo=  Por Tipo Comprobante";
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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodoDeclara(Long id_periodo_declara) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_declara!=null) {sDetalleIndice+=" Codigo Unico De Periodo Declara="+id_periodo_declara.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobante(Long id_tipo_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comprobante="+id_tipo_comprobante.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDocumentoAnulado(DocumentoAnulado documentoanulado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		documentoanulado.setnumero(documentoanulado.getnumero().trim());
		documentoanulado.setserie(documentoanulado.getserie().trim());
		documentoanulado.setautorizacion(documentoanulado.getautorizacion().trim());
	}
	
	public static void quitarEspaciosDocumentoAnulados(List<DocumentoAnulado> documentoanulados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DocumentoAnulado documentoanulado: documentoanulados) {
			documentoanulado.setnumero(documentoanulado.getnumero().trim());
			documentoanulado.setserie(documentoanulado.getserie().trim());
			documentoanulado.setautorizacion(documentoanulado.getautorizacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDocumentoAnulado(DocumentoAnulado documentoanulado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && documentoanulado.getConCambioAuxiliar()) {
			documentoanulado.setIsDeleted(documentoanulado.getIsDeletedAuxiliar());	
			documentoanulado.setIsNew(documentoanulado.getIsNewAuxiliar());	
			documentoanulado.setIsChanged(documentoanulado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			documentoanulado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			documentoanulado.setIsDeletedAuxiliar(false);	
			documentoanulado.setIsNewAuxiliar(false);	
			documentoanulado.setIsChangedAuxiliar(false);
			
			documentoanulado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDocumentoAnulados(List<DocumentoAnulado> documentoanulados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DocumentoAnulado documentoanulado : documentoanulados) {
			if(conAsignarBase && documentoanulado.getConCambioAuxiliar()) {
				documentoanulado.setIsDeleted(documentoanulado.getIsDeletedAuxiliar());	
				documentoanulado.setIsNew(documentoanulado.getIsNewAuxiliar());	
				documentoanulado.setIsChanged(documentoanulado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				documentoanulado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				documentoanulado.setIsDeletedAuxiliar(false);	
				documentoanulado.setIsNewAuxiliar(false);	
				documentoanulado.setIsChangedAuxiliar(false);
				
				documentoanulado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDocumentoAnulado(DocumentoAnulado documentoanulado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDocumentoAnulados(List<DocumentoAnulado> documentoanulados,Boolean conEnteros) throws Exception  {
		
		for(DocumentoAnulado documentoanulado: documentoanulados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDocumentoAnulado(List<DocumentoAnulado> documentoanulados,DocumentoAnulado documentoanuladoAux) throws Exception  {
		DocumentoAnuladoConstantesFunciones.InicializarValoresDocumentoAnulado(documentoanuladoAux,true);
		
		for(DocumentoAnulado documentoanulado: documentoanulados) {
			if(documentoanulado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDocumentoAnulado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DocumentoAnuladoConstantesFunciones.getArrayColumnasGlobalesDocumentoAnulado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDocumentoAnulado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DocumentoAnuladoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DocumentoAnuladoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DocumentoAnuladoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DocumentoAnuladoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDocumentoAnulado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DocumentoAnulado> documentoanulados,DocumentoAnulado documentoanulado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DocumentoAnulado documentoanuladoAux: documentoanulados) {
			if(documentoanuladoAux!=null && documentoanulado!=null) {
				if((documentoanuladoAux.getId()==null && documentoanulado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(documentoanuladoAux.getId()!=null && documentoanulado.getId()!=null){
					if(documentoanuladoAux.getId().equals(documentoanulado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDocumentoAnulado(List<DocumentoAnulado> documentoanulados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DocumentoAnulado documentoanulado: documentoanulados) {			
			if(documentoanulado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDocumentoAnulado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_ID, DocumentoAnuladoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_VERSIONROW, DocumentoAnuladoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_IDEMPRESA, DocumentoAnuladoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_IDPERIODODECLARA, DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_IDMODULO, DocumentoAnuladoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_IDTIPOCOMPROBANTE, DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_NUMERO, DocumentoAnuladoConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_SERIE, DocumentoAnuladoConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_AUTORIZACION, DocumentoAnuladoConstantesFunciones.AUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DocumentoAnuladoConstantesFunciones.LABEL_FECHAANULACION, DocumentoAnuladoConstantesFunciones.FECHAANULACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDocumentoAnulado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.AUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DocumentoAnuladoConstantesFunciones.FECHAANULACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDocumentoAnulado() throws Exception  {
		return DocumentoAnuladoConstantesFunciones.getTiposSeleccionarDocumentoAnulado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDocumentoAnulado(Boolean conFk) throws Exception  {
		return DocumentoAnuladoConstantesFunciones.getTiposSeleccionarDocumentoAnulado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDocumentoAnulado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_IDPERIODODECLARA);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_IDPERIODODECLARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_AUTORIZACION);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_AUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DocumentoAnuladoConstantesFunciones.LABEL_FECHAANULACION);
			reporte.setsDescripcion(DocumentoAnuladoConstantesFunciones.LABEL_FECHAANULACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDocumentoAnulado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDocumentoAnulado(DocumentoAnulado documentoanuladoAux) throws Exception {
		
			documentoanuladoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(documentoanuladoAux.getEmpresa()));
			documentoanuladoAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(documentoanuladoAux.getPeriodoDeclara()));
			documentoanuladoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(documentoanuladoAux.getModulo()));
			documentoanuladoAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(documentoanuladoAux.getTipoComprobante()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDocumentoAnulado(List<DocumentoAnulado> documentoanuladosTemp) throws Exception {
		for(DocumentoAnulado documentoanuladoAux:documentoanuladosTemp) {
			
			documentoanuladoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(documentoanuladoAux.getEmpresa()));
			documentoanuladoAux.setperiododeclara_descripcion(PeriodoDeclaraConstantesFunciones.getPeriodoDeclaraDescripcion(documentoanuladoAux.getPeriodoDeclara()));
			documentoanuladoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(documentoanuladoAux.getModulo()));
			documentoanuladoAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(documentoanuladoAux.getTipoComprobante()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDocumentoAnulado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(PeriodoDeclara.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoComprobante.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoDeclara.class)) {
						classes.add(new Classe(PeriodoDeclara.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComprobante.class)) {
						classes.add(new Classe(TipoComprobante.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDocumentoAnulado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(PeriodoDeclara.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoDeclara.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDocumentoAnulado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DocumentoAnuladoConstantesFunciones.getClassesRelationshipsOfDocumentoAnulado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDocumentoAnulado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDocumentoAnulado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DocumentoAnuladoConstantesFunciones.getClassesRelationshipsFromStringsOfDocumentoAnulado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDocumentoAnulado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DocumentoAnulado documentoanulado,List<DocumentoAnulado> documentoanulados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DocumentoAnulado documentoanuladoEncontrado=null;
			
			for(DocumentoAnulado documentoanuladoLocal:documentoanulados) {
				if(documentoanuladoLocal.getId().equals(documentoanulado.getId())) {
					documentoanuladoEncontrado=documentoanuladoLocal;
					
					documentoanuladoLocal.setIsChanged(documentoanulado.getIsChanged());
					documentoanuladoLocal.setIsNew(documentoanulado.getIsNew());
					documentoanuladoLocal.setIsDeleted(documentoanulado.getIsDeleted());
					
					documentoanuladoLocal.setGeneralEntityOriginal(documentoanulado.getGeneralEntityOriginal());
					
					documentoanuladoLocal.setId(documentoanulado.getId());	
					documentoanuladoLocal.setVersionRow(documentoanulado.getVersionRow());	
					documentoanuladoLocal.setid_empresa(documentoanulado.getid_empresa());	
					documentoanuladoLocal.setid_periodo_declara(documentoanulado.getid_periodo_declara());	
					documentoanuladoLocal.setid_modulo(documentoanulado.getid_modulo());	
					documentoanuladoLocal.setid_tipo_comprobante(documentoanulado.getid_tipo_comprobante());	
					documentoanuladoLocal.setnumero(documentoanulado.getnumero());	
					documentoanuladoLocal.setserie(documentoanulado.getserie());	
					documentoanuladoLocal.setautorizacion(documentoanulado.getautorizacion());	
					documentoanuladoLocal.setfecha_anulacion(documentoanulado.getfecha_anulacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!documentoanulado.getIsDeleted()) {
				if(!existe) {
					documentoanulados.add(documentoanulado);
				}
			} else {
				if(documentoanuladoEncontrado!=null && permiteQuitar)  {
					documentoanulados.remove(documentoanuladoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DocumentoAnulado documentoanulado,List<DocumentoAnulado> documentoanulados) throws Exception {
		try	{			
			for(DocumentoAnulado documentoanuladoLocal:documentoanulados) {
				if(documentoanuladoLocal.getId().equals(documentoanulado.getId())) {
					documentoanuladoLocal.setIsSelected(documentoanulado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDocumentoAnulado(List<DocumentoAnulado> documentoanuladosAux) throws Exception {
		//this.documentoanuladosAux=documentoanuladosAux;
		
		for(DocumentoAnulado documentoanuladoAux:documentoanuladosAux) {
			if(documentoanuladoAux.getIsChanged()) {
				documentoanuladoAux.setIsChanged(false);
			}		
			
			if(documentoanuladoAux.getIsNew()) {
				documentoanuladoAux.setIsNew(false);
			}	
			
			if(documentoanuladoAux.getIsDeleted()) {
				documentoanuladoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDocumentoAnulado(DocumentoAnulado documentoanuladoAux) throws Exception {
		//this.documentoanuladoAux=documentoanuladoAux;
		
			if(documentoanuladoAux.getIsChanged()) {
				documentoanuladoAux.setIsChanged(false);
			}		
			
			if(documentoanuladoAux.getIsNew()) {
				documentoanuladoAux.setIsNew(false);
			}	
			
			if(documentoanuladoAux.getIsDeleted()) {
				documentoanuladoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DocumentoAnulado documentoanuladoAsignar,DocumentoAnulado documentoanulado) throws Exception {
		documentoanuladoAsignar.setId(documentoanulado.getId());	
		documentoanuladoAsignar.setVersionRow(documentoanulado.getVersionRow());	
		documentoanuladoAsignar.setid_empresa(documentoanulado.getid_empresa());
		documentoanuladoAsignar.setempresa_descripcion(documentoanulado.getempresa_descripcion());	
		documentoanuladoAsignar.setid_periodo_declara(documentoanulado.getid_periodo_declara());
		documentoanuladoAsignar.setperiododeclara_descripcion(documentoanulado.getperiododeclara_descripcion());	
		documentoanuladoAsignar.setid_modulo(documentoanulado.getid_modulo());
		documentoanuladoAsignar.setmodulo_descripcion(documentoanulado.getmodulo_descripcion());	
		documentoanuladoAsignar.setid_tipo_comprobante(documentoanulado.getid_tipo_comprobante());
		documentoanuladoAsignar.settipocomprobante_descripcion(documentoanulado.gettipocomprobante_descripcion());	
		documentoanuladoAsignar.setnumero(documentoanulado.getnumero());	
		documentoanuladoAsignar.setserie(documentoanulado.getserie());	
		documentoanuladoAsignar.setautorizacion(documentoanulado.getautorizacion());	
		documentoanuladoAsignar.setfecha_anulacion(documentoanulado.getfecha_anulacion());	
	}
	
	public static void inicializarDocumentoAnulado(DocumentoAnulado documentoanulado) throws Exception {
		try {
				documentoanulado.setId(0L);	
					
				documentoanulado.setid_empresa(-1L);	
				documentoanulado.setid_periodo_declara(-1L);	
				documentoanulado.setid_modulo(-1L);	
				documentoanulado.setid_tipo_comprobante(-1L);	
				documentoanulado.setnumero("");	
				documentoanulado.setserie("");	
				documentoanulado.setautorizacion("");	
				documentoanulado.setfecha_anulacion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDocumentoAnulado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_IDPERIODODECLARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_AUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DocumentoAnuladoConstantesFunciones.LABEL_FECHAANULACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDocumentoAnulado(String sTipo,Row row,Workbook workbook,DocumentoAnulado documentoanulado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getperiododeclara_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.gettipocomprobante_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getautorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(documentoanulado.getfecha_anulacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDocumentoAnulado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDocumentoAnulado() {
		return this.sFinalQueryDocumentoAnulado;
	}
	
	public void setsFinalQueryDocumentoAnulado(String sFinalQueryDocumentoAnulado) {
		this.sFinalQueryDocumentoAnulado= sFinalQueryDocumentoAnulado;
	}
	
	public Border resaltarSeleccionarDocumentoAnulado=null;
	
	public Border setResaltarSeleccionarDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDocumentoAnulado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDocumentoAnulado() {
		return this.resaltarSeleccionarDocumentoAnulado;
	}
	
	public void setResaltarSeleccionarDocumentoAnulado(Border borderResaltarSeleccionarDocumentoAnulado) {
		this.resaltarSeleccionarDocumentoAnulado= borderResaltarSeleccionarDocumentoAnulado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDocumentoAnulado=null;
	public Boolean mostraridDocumentoAnulado=true;
	public Boolean activaridDocumentoAnulado=true;

	public Border resaltarid_empresaDocumentoAnulado=null;
	public Boolean mostrarid_empresaDocumentoAnulado=true;
	public Boolean activarid_empresaDocumentoAnulado=true;
	public Boolean cargarid_empresaDocumentoAnulado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDocumentoAnulado=false;//ConEventDepend=true

	public Border resaltarid_periodo_declaraDocumentoAnulado=null;
	public Boolean mostrarid_periodo_declaraDocumentoAnulado=true;
	public Boolean activarid_periodo_declaraDocumentoAnulado=true;
	public Boolean cargarid_periodo_declaraDocumentoAnulado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_declaraDocumentoAnulado=false;//ConEventDepend=true

	public Border resaltarid_moduloDocumentoAnulado=null;
	public Boolean mostrarid_moduloDocumentoAnulado=true;
	public Boolean activarid_moduloDocumentoAnulado=true;
	public Boolean cargarid_moduloDocumentoAnulado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDocumentoAnulado=false;//ConEventDepend=true

	public Border resaltarid_tipo_comprobanteDocumentoAnulado=null;
	public Boolean mostrarid_tipo_comprobanteDocumentoAnulado=true;
	public Boolean activarid_tipo_comprobanteDocumentoAnulado=true;
	public Boolean cargarid_tipo_comprobanteDocumentoAnulado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comprobanteDocumentoAnulado=false;//ConEventDepend=true

	public Border resaltarnumeroDocumentoAnulado=null;
	public Boolean mostrarnumeroDocumentoAnulado=true;
	public Boolean activarnumeroDocumentoAnulado=true;

	public Border resaltarserieDocumentoAnulado=null;
	public Boolean mostrarserieDocumentoAnulado=true;
	public Boolean activarserieDocumentoAnulado=true;

	public Border resaltarautorizacionDocumentoAnulado=null;
	public Boolean mostrarautorizacionDocumentoAnulado=true;
	public Boolean activarautorizacionDocumentoAnulado=true;

	public Border resaltarfecha_anulacionDocumentoAnulado=null;
	public Boolean mostrarfecha_anulacionDocumentoAnulado=true;
	public Boolean activarfecha_anulacionDocumentoAnulado=true;

	
	

	public Border setResaltaridDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltaridDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDocumentoAnulado() {
		return this.resaltaridDocumentoAnulado;
	}

	public void setResaltaridDocumentoAnulado(Border borderResaltar) {
		this.resaltaridDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostraridDocumentoAnulado() {
		return this.mostraridDocumentoAnulado;
	}

	public void setMostraridDocumentoAnulado(Boolean mostraridDocumentoAnulado) {
		this.mostraridDocumentoAnulado= mostraridDocumentoAnulado;
	}

	public Boolean getActivaridDocumentoAnulado() {
		return this.activaridDocumentoAnulado;
	}

	public void setActivaridDocumentoAnulado(Boolean activaridDocumentoAnulado) {
		this.activaridDocumentoAnulado= activaridDocumentoAnulado;
	}

	public Border setResaltarid_empresaDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarid_empresaDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDocumentoAnulado() {
		return this.resaltarid_empresaDocumentoAnulado;
	}

	public void setResaltarid_empresaDocumentoAnulado(Border borderResaltar) {
		this.resaltarid_empresaDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarid_empresaDocumentoAnulado() {
		return this.mostrarid_empresaDocumentoAnulado;
	}

	public void setMostrarid_empresaDocumentoAnulado(Boolean mostrarid_empresaDocumentoAnulado) {
		this.mostrarid_empresaDocumentoAnulado= mostrarid_empresaDocumentoAnulado;
	}

	public Boolean getActivarid_empresaDocumentoAnulado() {
		return this.activarid_empresaDocumentoAnulado;
	}

	public void setActivarid_empresaDocumentoAnulado(Boolean activarid_empresaDocumentoAnulado) {
		this.activarid_empresaDocumentoAnulado= activarid_empresaDocumentoAnulado;
	}

	public Boolean getCargarid_empresaDocumentoAnulado() {
		return this.cargarid_empresaDocumentoAnulado;
	}

	public void setCargarid_empresaDocumentoAnulado(Boolean cargarid_empresaDocumentoAnulado) {
		this.cargarid_empresaDocumentoAnulado= cargarid_empresaDocumentoAnulado;
	}

	public Border setResaltarid_periodo_declaraDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarid_periodo_declaraDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_declaraDocumentoAnulado() {
		return this.resaltarid_periodo_declaraDocumentoAnulado;
	}

	public void setResaltarid_periodo_declaraDocumentoAnulado(Border borderResaltar) {
		this.resaltarid_periodo_declaraDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarid_periodo_declaraDocumentoAnulado() {
		return this.mostrarid_periodo_declaraDocumentoAnulado;
	}

	public void setMostrarid_periodo_declaraDocumentoAnulado(Boolean mostrarid_periodo_declaraDocumentoAnulado) {
		this.mostrarid_periodo_declaraDocumentoAnulado= mostrarid_periodo_declaraDocumentoAnulado;
	}

	public Boolean getActivarid_periodo_declaraDocumentoAnulado() {
		return this.activarid_periodo_declaraDocumentoAnulado;
	}

	public void setActivarid_periodo_declaraDocumentoAnulado(Boolean activarid_periodo_declaraDocumentoAnulado) {
		this.activarid_periodo_declaraDocumentoAnulado= activarid_periodo_declaraDocumentoAnulado;
	}

	public Boolean getCargarid_periodo_declaraDocumentoAnulado() {
		return this.cargarid_periodo_declaraDocumentoAnulado;
	}

	public void setCargarid_periodo_declaraDocumentoAnulado(Boolean cargarid_periodo_declaraDocumentoAnulado) {
		this.cargarid_periodo_declaraDocumentoAnulado= cargarid_periodo_declaraDocumentoAnulado;
	}

	public Border setResaltarid_moduloDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarid_moduloDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDocumentoAnulado() {
		return this.resaltarid_moduloDocumentoAnulado;
	}

	public void setResaltarid_moduloDocumentoAnulado(Border borderResaltar) {
		this.resaltarid_moduloDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarid_moduloDocumentoAnulado() {
		return this.mostrarid_moduloDocumentoAnulado;
	}

	public void setMostrarid_moduloDocumentoAnulado(Boolean mostrarid_moduloDocumentoAnulado) {
		this.mostrarid_moduloDocumentoAnulado= mostrarid_moduloDocumentoAnulado;
	}

	public Boolean getActivarid_moduloDocumentoAnulado() {
		return this.activarid_moduloDocumentoAnulado;
	}

	public void setActivarid_moduloDocumentoAnulado(Boolean activarid_moduloDocumentoAnulado) {
		this.activarid_moduloDocumentoAnulado= activarid_moduloDocumentoAnulado;
	}

	public Boolean getCargarid_moduloDocumentoAnulado() {
		return this.cargarid_moduloDocumentoAnulado;
	}

	public void setCargarid_moduloDocumentoAnulado(Boolean cargarid_moduloDocumentoAnulado) {
		this.cargarid_moduloDocumentoAnulado= cargarid_moduloDocumentoAnulado;
	}

	public Border setResaltarid_tipo_comprobanteDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_comprobanteDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comprobanteDocumentoAnulado() {
		return this.resaltarid_tipo_comprobanteDocumentoAnulado;
	}

	public void setResaltarid_tipo_comprobanteDocumentoAnulado(Border borderResaltar) {
		this.resaltarid_tipo_comprobanteDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comprobanteDocumentoAnulado() {
		return this.mostrarid_tipo_comprobanteDocumentoAnulado;
	}

	public void setMostrarid_tipo_comprobanteDocumentoAnulado(Boolean mostrarid_tipo_comprobanteDocumentoAnulado) {
		this.mostrarid_tipo_comprobanteDocumentoAnulado= mostrarid_tipo_comprobanteDocumentoAnulado;
	}

	public Boolean getActivarid_tipo_comprobanteDocumentoAnulado() {
		return this.activarid_tipo_comprobanteDocumentoAnulado;
	}

	public void setActivarid_tipo_comprobanteDocumentoAnulado(Boolean activarid_tipo_comprobanteDocumentoAnulado) {
		this.activarid_tipo_comprobanteDocumentoAnulado= activarid_tipo_comprobanteDocumentoAnulado;
	}

	public Boolean getCargarid_tipo_comprobanteDocumentoAnulado() {
		return this.cargarid_tipo_comprobanteDocumentoAnulado;
	}

	public void setCargarid_tipo_comprobanteDocumentoAnulado(Boolean cargarid_tipo_comprobanteDocumentoAnulado) {
		this.cargarid_tipo_comprobanteDocumentoAnulado= cargarid_tipo_comprobanteDocumentoAnulado;
	}

	public Border setResaltarnumeroDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarnumeroDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroDocumentoAnulado() {
		return this.resaltarnumeroDocumentoAnulado;
	}

	public void setResaltarnumeroDocumentoAnulado(Border borderResaltar) {
		this.resaltarnumeroDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarnumeroDocumentoAnulado() {
		return this.mostrarnumeroDocumentoAnulado;
	}

	public void setMostrarnumeroDocumentoAnulado(Boolean mostrarnumeroDocumentoAnulado) {
		this.mostrarnumeroDocumentoAnulado= mostrarnumeroDocumentoAnulado;
	}

	public Boolean getActivarnumeroDocumentoAnulado() {
		return this.activarnumeroDocumentoAnulado;
	}

	public void setActivarnumeroDocumentoAnulado(Boolean activarnumeroDocumentoAnulado) {
		this.activarnumeroDocumentoAnulado= activarnumeroDocumentoAnulado;
	}

	public Border setResaltarserieDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarserieDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDocumentoAnulado() {
		return this.resaltarserieDocumentoAnulado;
	}

	public void setResaltarserieDocumentoAnulado(Border borderResaltar) {
		this.resaltarserieDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarserieDocumentoAnulado() {
		return this.mostrarserieDocumentoAnulado;
	}

	public void setMostrarserieDocumentoAnulado(Boolean mostrarserieDocumentoAnulado) {
		this.mostrarserieDocumentoAnulado= mostrarserieDocumentoAnulado;
	}

	public Boolean getActivarserieDocumentoAnulado() {
		return this.activarserieDocumentoAnulado;
	}

	public void setActivarserieDocumentoAnulado(Boolean activarserieDocumentoAnulado) {
		this.activarserieDocumentoAnulado= activarserieDocumentoAnulado;
	}

	public Border setResaltarautorizacionDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarautorizacionDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacionDocumentoAnulado() {
		return this.resaltarautorizacionDocumentoAnulado;
	}

	public void setResaltarautorizacionDocumentoAnulado(Border borderResaltar) {
		this.resaltarautorizacionDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarautorizacionDocumentoAnulado() {
		return this.mostrarautorizacionDocumentoAnulado;
	}

	public void setMostrarautorizacionDocumentoAnulado(Boolean mostrarautorizacionDocumentoAnulado) {
		this.mostrarautorizacionDocumentoAnulado= mostrarautorizacionDocumentoAnulado;
	}

	public Boolean getActivarautorizacionDocumentoAnulado() {
		return this.activarautorizacionDocumentoAnulado;
	}

	public void setActivarautorizacionDocumentoAnulado(Boolean activarautorizacionDocumentoAnulado) {
		this.activarautorizacionDocumentoAnulado= activarautorizacionDocumentoAnulado;
	}

	public Border setResaltarfecha_anulacionDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//documentoanuladoBeanSwingJInternalFrame.jTtoolBarDocumentoAnulado.setBorder(borderResaltar);
		
		this.resaltarfecha_anulacionDocumentoAnulado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_anulacionDocumentoAnulado() {
		return this.resaltarfecha_anulacionDocumentoAnulado;
	}

	public void setResaltarfecha_anulacionDocumentoAnulado(Border borderResaltar) {
		this.resaltarfecha_anulacionDocumentoAnulado= borderResaltar;
	}

	public Boolean getMostrarfecha_anulacionDocumentoAnulado() {
		return this.mostrarfecha_anulacionDocumentoAnulado;
	}

	public void setMostrarfecha_anulacionDocumentoAnulado(Boolean mostrarfecha_anulacionDocumentoAnulado) {
		this.mostrarfecha_anulacionDocumentoAnulado= mostrarfecha_anulacionDocumentoAnulado;
	}

	public Boolean getActivarfecha_anulacionDocumentoAnulado() {
		return this.activarfecha_anulacionDocumentoAnulado;
	}

	public void setActivarfecha_anulacionDocumentoAnulado(Boolean activarfecha_anulacionDocumentoAnulado) {
		this.activarfecha_anulacionDocumentoAnulado= activarfecha_anulacionDocumentoAnulado;
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
		
		
		this.setMostraridDocumentoAnulado(esInicial);
		this.setMostrarid_empresaDocumentoAnulado(esInicial);
		this.setMostrarid_periodo_declaraDocumentoAnulado(esInicial);
		this.setMostrarid_moduloDocumentoAnulado(esInicial);
		this.setMostrarid_tipo_comprobanteDocumentoAnulado(esInicial);
		this.setMostrarnumeroDocumentoAnulado(esInicial);
		this.setMostrarserieDocumentoAnulado(esInicial);
		this.setMostrarautorizacionDocumentoAnulado(esInicial);
		this.setMostrarfecha_anulacionDocumentoAnulado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.ID)) {
				this.setMostraridDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA)) {
				this.setMostrarid_periodo_declaraDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setMostrarid_tipo_comprobanteDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.SERIE)) {
				this.setMostrarserieDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.AUTORIZACION)) {
				this.setMostrarautorizacionDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.FECHAANULACION)) {
				this.setMostrarfecha_anulacionDocumentoAnulado(esAsigna);
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
		
		
		this.setActivaridDocumentoAnulado(esInicial);
		this.setActivarid_empresaDocumentoAnulado(esInicial);
		this.setActivarid_periodo_declaraDocumentoAnulado(esInicial);
		this.setActivarid_moduloDocumentoAnulado(esInicial);
		this.setActivarid_tipo_comprobanteDocumentoAnulado(esInicial);
		this.setActivarnumeroDocumentoAnulado(esInicial);
		this.setActivarserieDocumentoAnulado(esInicial);
		this.setActivarautorizacionDocumentoAnulado(esInicial);
		this.setActivarfecha_anulacionDocumentoAnulado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.ID)) {
				this.setActivaridDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA)) {
				this.setActivarid_periodo_declaraDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setActivarid_tipo_comprobanteDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.NUMERO)) {
				this.setActivarnumeroDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.SERIE)) {
				this.setActivarserieDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.AUTORIZACION)) {
				this.setActivarautorizacionDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.FECHAANULACION)) {
				this.setActivarfecha_anulacionDocumentoAnulado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDocumentoAnulado(esInicial);
		this.setResaltarid_empresaDocumentoAnulado(esInicial);
		this.setResaltarid_periodo_declaraDocumentoAnulado(esInicial);
		this.setResaltarid_moduloDocumentoAnulado(esInicial);
		this.setResaltarid_tipo_comprobanteDocumentoAnulado(esInicial);
		this.setResaltarnumeroDocumentoAnulado(esInicial);
		this.setResaltarserieDocumentoAnulado(esInicial);
		this.setResaltarautorizacionDocumentoAnulado(esInicial);
		this.setResaltarfecha_anulacionDocumentoAnulado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.ID)) {
				this.setResaltaridDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA)) {
				this.setResaltarid_periodo_declaraDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setResaltarid_tipo_comprobanteDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.SERIE)) {
				this.setResaltarserieDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.AUTORIZACION)) {
				this.setResaltarautorizacionDocumentoAnulado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DocumentoAnuladoConstantesFunciones.FECHAANULACION)) {
				this.setResaltarfecha_anulacionDocumentoAnulado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaDocumentoAnulado=true;

	public Boolean getMostrarFK_IdEmpresaDocumentoAnulado() {
		return this.mostrarFK_IdEmpresaDocumentoAnulado;
	}

	public void setMostrarFK_IdEmpresaDocumentoAnulado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDocumentoAnulado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDocumentoAnulado=true;

	public Boolean getMostrarFK_IdModuloDocumentoAnulado() {
		return this.mostrarFK_IdModuloDocumentoAnulado;
	}

	public void setMostrarFK_IdModuloDocumentoAnulado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDocumentoAnulado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDeclaraDocumentoAnulado=true;

	public Boolean getMostrarFK_IdPeriodoDeclaraDocumentoAnulado() {
		return this.mostrarFK_IdPeriodoDeclaraDocumentoAnulado;
	}

	public void setMostrarFK_IdPeriodoDeclaraDocumentoAnulado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDeclaraDocumentoAnulado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComprobanteDocumentoAnulado=true;

	public Boolean getMostrarFK_IdTipoComprobanteDocumentoAnulado() {
		return this.mostrarFK_IdTipoComprobanteDocumentoAnulado;
	}

	public void setMostrarFK_IdTipoComprobanteDocumentoAnulado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComprobanteDocumentoAnulado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaDocumentoAnulado=true;

	public Boolean getActivarFK_IdEmpresaDocumentoAnulado() {
		return this.activarFK_IdEmpresaDocumentoAnulado;
	}

	public void setActivarFK_IdEmpresaDocumentoAnulado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDocumentoAnulado= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDocumentoAnulado=true;

	public Boolean getActivarFK_IdModuloDocumentoAnulado() {
		return this.activarFK_IdModuloDocumentoAnulado;
	}

	public void setActivarFK_IdModuloDocumentoAnulado(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDocumentoAnulado= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDeclaraDocumentoAnulado=true;

	public Boolean getActivarFK_IdPeriodoDeclaraDocumentoAnulado() {
		return this.activarFK_IdPeriodoDeclaraDocumentoAnulado;
	}

	public void setActivarFK_IdPeriodoDeclaraDocumentoAnulado(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDeclaraDocumentoAnulado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComprobanteDocumentoAnulado=true;

	public Boolean getActivarFK_IdTipoComprobanteDocumentoAnulado() {
		return this.activarFK_IdTipoComprobanteDocumentoAnulado;
	}

	public void setActivarFK_IdTipoComprobanteDocumentoAnulado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComprobanteDocumentoAnulado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaDocumentoAnulado=null;

	public Border getResaltarFK_IdEmpresaDocumentoAnulado() {
		return this.resaltarFK_IdEmpresaDocumentoAnulado;
	}

	public void setResaltarFK_IdEmpresaDocumentoAnulado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDocumentoAnulado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDocumentoAnulado= borderResaltar;
	}

	public Border resaltarFK_IdModuloDocumentoAnulado=null;

	public Border getResaltarFK_IdModuloDocumentoAnulado() {
		return this.resaltarFK_IdModuloDocumentoAnulado;
	}

	public void setResaltarFK_IdModuloDocumentoAnulado(Border borderResaltar) {
		this.resaltarFK_IdModuloDocumentoAnulado= borderResaltar;
	}

	public void setResaltarFK_IdModuloDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDocumentoAnulado= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDeclaraDocumentoAnulado=null;

	public Border getResaltarFK_IdPeriodoDeclaraDocumentoAnulado() {
		return this.resaltarFK_IdPeriodoDeclaraDocumentoAnulado;
	}

	public void setResaltarFK_IdPeriodoDeclaraDocumentoAnulado(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDeclaraDocumentoAnulado= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDeclaraDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDeclaraDocumentoAnulado= borderResaltar;
	}

	public Border resaltarFK_IdTipoComprobanteDocumentoAnulado=null;

	public Border getResaltarFK_IdTipoComprobanteDocumentoAnulado() {
		return this.resaltarFK_IdTipoComprobanteDocumentoAnulado;
	}

	public void setResaltarFK_IdTipoComprobanteDocumentoAnulado(Border borderResaltar) {
		this.resaltarFK_IdTipoComprobanteDocumentoAnulado= borderResaltar;
	}

	public void setResaltarFK_IdTipoComprobanteDocumentoAnulado(ParametroGeneralUsuario parametroGeneralUsuario/*DocumentoAnuladoBeanSwingJInternalFrame documentoanuladoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComprobanteDocumentoAnulado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}