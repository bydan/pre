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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.ParametroGeneralConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroGeneralParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroGeneralParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroGeneralConstantesFunciones extends ParametroGeneralConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroGeneral";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroGeneral"+ParametroGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroGeneralConstantesFunciones.SCHEMA+"_"+ParametroGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroGeneralConstantesFunciones.SCHEMA+"_"+ParametroGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroGeneralConstantesFunciones.SCHEMA+"_"+ParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroGeneralConstantesFunciones.SCHEMA+"_"+ParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Generals";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro General";
	public static final String SCLASSWEBTITULO_LOWER="Parametro General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroGeneral";
	public static final String OBJECTNAME="parametrogeneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrogeneral from "+ParametroGeneralConstantesFunciones.SPERSISTENCENAME+" parametrogeneral";
	public static String QUERYSELECTNATIVE="select "+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".id,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".version_row,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".id_tipo_documento_general,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".numero_secuencial,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".numero_autor,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".fecha_inicio,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".fecha_fin,"+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME+".esta_activo from "+ParametroGeneralConstantesFunciones.SCHEMA+"."+ParametroGeneralConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroGeneralConstantesFuncionesAdditional parametrogeneralConstantesFuncionesAdditional=null;
	
	public ParametroGeneralConstantesFuncionesAdditional getParametroGeneralConstantesFuncionesAdditional() {
		return this.parametrogeneralConstantesFuncionesAdditional;
	}
	
	public void setParametroGeneralConstantesFuncionesAdditional(ParametroGeneralConstantesFuncionesAdditional parametrogeneralConstantesFuncionesAdditional) {
		try {
			this.parametrogeneralConstantesFuncionesAdditional=parametrogeneralConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPODOCUMENTOGENERAL= "id_tipo_documento_general";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String NUMEROAUTOR= "numero_autor";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPODOCUMENTOGENERAL= "Tipo Documento General";
		public static final String LABEL_IDTIPODOCUMENTOGENERAL_LOWER= "Tipo Documento General";
    	public static final String LABEL_NUMEROSECUENCIAL= "Numero Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_NUMEROAUTOR= "Numero Autor";
		public static final String LABEL_NUMEROAUTOR_LOWER= "Numero Autor";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getParametroGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.NUMEROAUTOR)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_NUMEROAUTOR;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.FECHAINICIO)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.FECHAFIN)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ParametroGeneralConstantesFunciones.ESTAACTIVO)) {sLabelColumna=ParametroGeneralConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(ParametroGeneral parametrogeneral) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogeneral.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(ParametroGeneral parametrogeneral) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogeneral.getId(),parametrogeneral.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getParametroGeneralDescripcion(ParametroGeneral parametrogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrogeneral !=null/* && parametrogeneral.getId()!=0*/) {
			if(parametrogeneral.getId()!=null) {
				sDescripcion=parametrogeneral.getId().toString();
			}//parametrogeneralparametrogeneral.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroGeneralDescripcionDetallado(ParametroGeneral parametrogeneral) {
		String sDescripcion="";
			
		sDescripcion+=ParametroGeneralConstantesFunciones.ID+"=";
		sDescripcion+=parametrogeneral.getId().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrogeneral.getVersionRow().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrogeneral.getid_empresa().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrogeneral.getid_sucursal().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL+"=";
		sDescripcion+=parametrogeneral.getid_tipo_documento_general().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=parametrogeneral.getnumero_secuencial()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.NUMEROAUTOR+"=";
		sDescripcion+=parametrogeneral.getnumero_autor()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=parametrogeneral.getfecha_inicio().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=parametrogeneral.getfecha_fin().toString()+",";
		sDescripcion+=ParametroGeneralConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=parametrogeneral.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroGeneralDescripcion(ParametroGeneral parametrogeneral,String sValor) throws Exception {			
		if(parametrogeneral !=null) {
			//parametrogeneralparametrogeneral.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoGeneralDescripcion(TipoDocumentoGeneral tipodocumentogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumentogeneral!=null/*&&tipodocumentogeneral.getId()>0*/) {
			sDescripcion=TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(tipodocumentogeneral);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdSucursalEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoGeneral")) {
			sNombreIndice="Tipo=  Por Tipo Documento General";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursalEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoGeneral(Long id_tipo_documento_general) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_general!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento General="+id_tipo_documento_general.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroGeneral(ParametroGeneral parametrogeneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrogeneral.setnumero_secuencial(parametrogeneral.getnumero_secuencial().trim());
		parametrogeneral.setnumero_autor(parametrogeneral.getnumero_autor().trim());
	}
	
	public static void quitarEspaciosParametroGenerals(List<ParametroGeneral> parametrogenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroGeneral parametrogeneral: parametrogenerals) {
			parametrogeneral.setnumero_secuencial(parametrogeneral.getnumero_secuencial().trim());
			parametrogeneral.setnumero_autor(parametrogeneral.getnumero_autor().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGeneral(ParametroGeneral parametrogeneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrogeneral.getConCambioAuxiliar()) {
			parametrogeneral.setIsDeleted(parametrogeneral.getIsDeletedAuxiliar());	
			parametrogeneral.setIsNew(parametrogeneral.getIsNewAuxiliar());	
			parametrogeneral.setIsChanged(parametrogeneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrogeneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrogeneral.setIsDeletedAuxiliar(false);	
			parametrogeneral.setIsNewAuxiliar(false);	
			parametrogeneral.setIsChangedAuxiliar(false);
			
			parametrogeneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGenerals(List<ParametroGeneral> parametrogenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroGeneral parametrogeneral : parametrogenerals) {
			if(conAsignarBase && parametrogeneral.getConCambioAuxiliar()) {
				parametrogeneral.setIsDeleted(parametrogeneral.getIsDeletedAuxiliar());	
				parametrogeneral.setIsNew(parametrogeneral.getIsNewAuxiliar());	
				parametrogeneral.setIsChanged(parametrogeneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrogeneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrogeneral.setIsDeletedAuxiliar(false);	
				parametrogeneral.setIsNewAuxiliar(false);	
				parametrogeneral.setIsChangedAuxiliar(false);
				
				parametrogeneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroGeneral(ParametroGeneral parametrogeneral,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroGenerals(List<ParametroGeneral> parametrogenerals,Boolean conEnteros) throws Exception  {
		
		for(ParametroGeneral parametrogeneral: parametrogenerals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroGeneral(List<ParametroGeneral> parametrogenerals,ParametroGeneral parametrogeneralAux) throws Exception  {
		ParametroGeneralConstantesFunciones.InicializarValoresParametroGeneral(parametrogeneralAux,true);
		
		for(ParametroGeneral parametrogeneral: parametrogenerals) {
			if(parametrogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroGeneralConstantesFunciones.getArrayColumnasGlobalesParametroGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroGeneralConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroGeneralConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroGeneralConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroGeneralConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroGeneral> parametrogenerals,ParametroGeneral parametrogeneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroGeneral parametrogeneralAux: parametrogenerals) {
			if(parametrogeneralAux!=null && parametrogeneral!=null) {
				if((parametrogeneralAux.getId()==null && parametrogeneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrogeneralAux.getId()!=null && parametrogeneral.getId()!=null){
					if(parametrogeneralAux.getId().equals(parametrogeneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroGeneral(List<ParametroGeneral> parametrogenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroGeneral parametrogeneral: parametrogenerals) {			
			if(parametrogeneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_ID, ParametroGeneralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_VERSIONROW, ParametroGeneralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_IDEMPRESA, ParametroGeneralConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_IDSUCURSAL, ParametroGeneralConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL, ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_NUMEROSECUENCIAL, ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_NUMEROAUTOR, ParametroGeneralConstantesFunciones.NUMEROAUTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_FECHAINICIO, ParametroGeneralConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_FECHAFIN, ParametroGeneralConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGeneralConstantesFunciones.LABEL_ESTAACTIVO, ParametroGeneralConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.NUMEROAUTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGeneralConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneral() throws Exception  {
		return ParametroGeneralConstantesFunciones.getTiposSeleccionarParametroGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneral(Boolean conFk) throws Exception  {
		return ParametroGeneralConstantesFunciones.getTiposSeleccionarParametroGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_NUMEROAUTOR);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_NUMEROAUTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGeneralConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(ParametroGeneralConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGeneral(ParametroGeneral parametrogeneralAux) throws Exception {
		
			parametrogeneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrogeneralAux.getEmpresa()));
			parametrogeneralAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrogeneralAux.getSucursal()));
			parametrogeneralAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(parametrogeneralAux.getTipoDocumentoGeneral()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGeneral(List<ParametroGeneral> parametrogeneralsTemp) throws Exception {
		for(ParametroGeneral parametrogeneralAux:parametrogeneralsTemp) {
			
			parametrogeneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrogeneralAux.getEmpresa()));
			parametrogeneralAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrogeneralAux.getSucursal()));
			parametrogeneralAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(parametrogeneralAux.getTipoDocumentoGeneral()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoDocumentoGeneral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumentoGeneral.class)) {
						classes.add(new Classe(TipoDocumentoGeneral.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoDocumentoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumentoGeneral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoDocumentoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumentoGeneral.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGeneralConstantesFunciones.getClassesRelationshipsOfParametroGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfParametroGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroGeneral parametrogeneral,List<ParametroGeneral> parametrogenerals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroGeneral parametrogeneralEncontrado=null;
			
			for(ParametroGeneral parametrogeneralLocal:parametrogenerals) {
				if(parametrogeneralLocal.getId().equals(parametrogeneral.getId())) {
					parametrogeneralEncontrado=parametrogeneralLocal;
					
					parametrogeneralLocal.setIsChanged(parametrogeneral.getIsChanged());
					parametrogeneralLocal.setIsNew(parametrogeneral.getIsNew());
					parametrogeneralLocal.setIsDeleted(parametrogeneral.getIsDeleted());
					
					parametrogeneralLocal.setGeneralEntityOriginal(parametrogeneral.getGeneralEntityOriginal());
					
					parametrogeneralLocal.setId(parametrogeneral.getId());	
					parametrogeneralLocal.setVersionRow(parametrogeneral.getVersionRow());	
					parametrogeneralLocal.setid_empresa(parametrogeneral.getid_empresa());	
					parametrogeneralLocal.setid_sucursal(parametrogeneral.getid_sucursal());	
					parametrogeneralLocal.setid_tipo_documento_general(parametrogeneral.getid_tipo_documento_general());	
					parametrogeneralLocal.setnumero_secuencial(parametrogeneral.getnumero_secuencial());	
					parametrogeneralLocal.setnumero_autor(parametrogeneral.getnumero_autor());	
					parametrogeneralLocal.setfecha_inicio(parametrogeneral.getfecha_inicio());	
					parametrogeneralLocal.setfecha_fin(parametrogeneral.getfecha_fin());	
					parametrogeneralLocal.setesta_activo(parametrogeneral.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrogeneral.getIsDeleted()) {
				if(!existe) {
					parametrogenerals.add(parametrogeneral);
				}
			} else {
				if(parametrogeneralEncontrado!=null && permiteQuitar)  {
					parametrogenerals.remove(parametrogeneralEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroGeneral parametrogeneral,List<ParametroGeneral> parametrogenerals) throws Exception {
		try	{			
			for(ParametroGeneral parametrogeneralLocal:parametrogenerals) {
				if(parametrogeneralLocal.getId().equals(parametrogeneral.getId())) {
					parametrogeneralLocal.setIsSelected(parametrogeneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroGeneral(List<ParametroGeneral> parametrogeneralsAux) throws Exception {
		//this.parametrogeneralsAux=parametrogeneralsAux;
		
		for(ParametroGeneral parametrogeneralAux:parametrogeneralsAux) {
			if(parametrogeneralAux.getIsChanged()) {
				parametrogeneralAux.setIsChanged(false);
			}		
			
			if(parametrogeneralAux.getIsNew()) {
				parametrogeneralAux.setIsNew(false);
			}	
			
			if(parametrogeneralAux.getIsDeleted()) {
				parametrogeneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroGeneral(ParametroGeneral parametrogeneralAux) throws Exception {
		//this.parametrogeneralAux=parametrogeneralAux;
		
			if(parametrogeneralAux.getIsChanged()) {
				parametrogeneralAux.setIsChanged(false);
			}		
			
			if(parametrogeneralAux.getIsNew()) {
				parametrogeneralAux.setIsNew(false);
			}	
			
			if(parametrogeneralAux.getIsDeleted()) {
				parametrogeneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroGeneral parametrogeneralAsignar,ParametroGeneral parametrogeneral) throws Exception {
		parametrogeneralAsignar.setId(parametrogeneral.getId());	
		parametrogeneralAsignar.setVersionRow(parametrogeneral.getVersionRow());	
		parametrogeneralAsignar.setid_empresa(parametrogeneral.getid_empresa());
		parametrogeneralAsignar.setempresa_descripcion(parametrogeneral.getempresa_descripcion());	
		parametrogeneralAsignar.setid_sucursal(parametrogeneral.getid_sucursal());
		parametrogeneralAsignar.setsucursal_descripcion(parametrogeneral.getsucursal_descripcion());	
		parametrogeneralAsignar.setid_tipo_documento_general(parametrogeneral.getid_tipo_documento_general());
		parametrogeneralAsignar.settipodocumentogeneral_descripcion(parametrogeneral.gettipodocumentogeneral_descripcion());	
		parametrogeneralAsignar.setnumero_secuencial(parametrogeneral.getnumero_secuencial());	
		parametrogeneralAsignar.setnumero_autor(parametrogeneral.getnumero_autor());	
		parametrogeneralAsignar.setfecha_inicio(parametrogeneral.getfecha_inicio());	
		parametrogeneralAsignar.setfecha_fin(parametrogeneral.getfecha_fin());	
		parametrogeneralAsignar.setesta_activo(parametrogeneral.getesta_activo());	
	}
	
	public static void inicializarParametroGeneral(ParametroGeneral parametrogeneral) throws Exception {
		try {
				parametrogeneral.setId(0L);	
					
				parametrogeneral.setid_empresa(-1L);	
				parametrogeneral.setid_sucursal(-1L);	
				parametrogeneral.setid_tipo_documento_general(-1L);	
				parametrogeneral.setnumero_secuencial("");	
				parametrogeneral.setnumero_autor("");	
				parametrogeneral.setfecha_inicio(new Date());	
				parametrogeneral.setfecha_fin(new Date());	
				parametrogeneral.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_NUMEROAUTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGeneralConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroGeneral(String sTipo,Row row,Workbook workbook,ParametroGeneral parametrogeneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.gettipodocumentogeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.getnumero_autor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogeneral.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogeneral.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroGeneral=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroGeneral() {
		return this.sFinalQueryParametroGeneral;
	}
	
	public void setsFinalQueryParametroGeneral(String sFinalQueryParametroGeneral) {
		this.sFinalQueryParametroGeneral= sFinalQueryParametroGeneral;
	}
	
	public Border resaltarSeleccionarParametroGeneral=null;
	
	public Border setResaltarSeleccionarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroGeneral() {
		return this.resaltarSeleccionarParametroGeneral;
	}
	
	public void setResaltarSeleccionarParametroGeneral(Border borderResaltarSeleccionarParametroGeneral) {
		this.resaltarSeleccionarParametroGeneral= borderResaltarSeleccionarParametroGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroGeneral=null;
	public Boolean mostraridParametroGeneral=true;
	public Boolean activaridParametroGeneral=true;

	public Border resaltarid_empresaParametroGeneral=null;
	public Boolean mostrarid_empresaParametroGeneral=true;
	public Boolean activarid_empresaParametroGeneral=true;
	public Boolean cargarid_empresaParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroGeneral=null;
	public Boolean mostrarid_sucursalParametroGeneral=true;
	public Boolean activarid_sucursalParametroGeneral=true;
	public Boolean cargarid_sucursalParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroGeneral=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_generalParametroGeneral=null;
	public Boolean mostrarid_tipo_documento_generalParametroGeneral=true;
	public Boolean activarid_tipo_documento_generalParametroGeneral=true;
	public Boolean cargarid_tipo_documento_generalParametroGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_generalParametroGeneral=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialParametroGeneral=null;
	public Boolean mostrarnumero_secuencialParametroGeneral=true;
	public Boolean activarnumero_secuencialParametroGeneral=true;

	public Border resaltarnumero_autorParametroGeneral=null;
	public Boolean mostrarnumero_autorParametroGeneral=true;
	public Boolean activarnumero_autorParametroGeneral=true;

	public Border resaltarfecha_inicioParametroGeneral=null;
	public Boolean mostrarfecha_inicioParametroGeneral=true;
	public Boolean activarfecha_inicioParametroGeneral=false;

	public Border resaltarfecha_finParametroGeneral=null;
	public Boolean mostrarfecha_finParametroGeneral=true;
	public Boolean activarfecha_finParametroGeneral=false;

	public Border resaltaresta_activoParametroGeneral=null;
	public Boolean mostraresta_activoParametroGeneral=true;
	public Boolean activaresta_activoParametroGeneral=true;

	
	

	public Border setResaltaridParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltaridParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroGeneral() {
		return this.resaltaridParametroGeneral;
	}

	public void setResaltaridParametroGeneral(Border borderResaltar) {
		this.resaltaridParametroGeneral= borderResaltar;
	}

	public Boolean getMostraridParametroGeneral() {
		return this.mostraridParametroGeneral;
	}

	public void setMostraridParametroGeneral(Boolean mostraridParametroGeneral) {
		this.mostraridParametroGeneral= mostraridParametroGeneral;
	}

	public Boolean getActivaridParametroGeneral() {
		return this.activaridParametroGeneral;
	}

	public void setActivaridParametroGeneral(Boolean activaridParametroGeneral) {
		this.activaridParametroGeneral= activaridParametroGeneral;
	}

	public Border setResaltarid_empresaParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroGeneral() {
		return this.resaltarid_empresaParametroGeneral;
	}

	public void setResaltarid_empresaParametroGeneral(Border borderResaltar) {
		this.resaltarid_empresaParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroGeneral() {
		return this.mostrarid_empresaParametroGeneral;
	}

	public void setMostrarid_empresaParametroGeneral(Boolean mostrarid_empresaParametroGeneral) {
		this.mostrarid_empresaParametroGeneral= mostrarid_empresaParametroGeneral;
	}

	public Boolean getActivarid_empresaParametroGeneral() {
		return this.activarid_empresaParametroGeneral;
	}

	public void setActivarid_empresaParametroGeneral(Boolean activarid_empresaParametroGeneral) {
		this.activarid_empresaParametroGeneral= activarid_empresaParametroGeneral;
	}

	public Boolean getCargarid_empresaParametroGeneral() {
		return this.cargarid_empresaParametroGeneral;
	}

	public void setCargarid_empresaParametroGeneral(Boolean cargarid_empresaParametroGeneral) {
		this.cargarid_empresaParametroGeneral= cargarid_empresaParametroGeneral;
	}

	public Border setResaltarid_sucursalParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroGeneral() {
		return this.resaltarid_sucursalParametroGeneral;
	}

	public void setResaltarid_sucursalParametroGeneral(Border borderResaltar) {
		this.resaltarid_sucursalParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroGeneral() {
		return this.mostrarid_sucursalParametroGeneral;
	}

	public void setMostrarid_sucursalParametroGeneral(Boolean mostrarid_sucursalParametroGeneral) {
		this.mostrarid_sucursalParametroGeneral= mostrarid_sucursalParametroGeneral;
	}

	public Boolean getActivarid_sucursalParametroGeneral() {
		return this.activarid_sucursalParametroGeneral;
	}

	public void setActivarid_sucursalParametroGeneral(Boolean activarid_sucursalParametroGeneral) {
		this.activarid_sucursalParametroGeneral= activarid_sucursalParametroGeneral;
	}

	public Boolean getCargarid_sucursalParametroGeneral() {
		return this.cargarid_sucursalParametroGeneral;
	}

	public void setCargarid_sucursalParametroGeneral(Boolean cargarid_sucursalParametroGeneral) {
		this.cargarid_sucursalParametroGeneral= cargarid_sucursalParametroGeneral;
	}

	public Border setResaltarid_tipo_documento_generalParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_generalParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_generalParametroGeneral() {
		return this.resaltarid_tipo_documento_generalParametroGeneral;
	}

	public void setResaltarid_tipo_documento_generalParametroGeneral(Border borderResaltar) {
		this.resaltarid_tipo_documento_generalParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_generalParametroGeneral() {
		return this.mostrarid_tipo_documento_generalParametroGeneral;
	}

	public void setMostrarid_tipo_documento_generalParametroGeneral(Boolean mostrarid_tipo_documento_generalParametroGeneral) {
		this.mostrarid_tipo_documento_generalParametroGeneral= mostrarid_tipo_documento_generalParametroGeneral;
	}

	public Boolean getActivarid_tipo_documento_generalParametroGeneral() {
		return this.activarid_tipo_documento_generalParametroGeneral;
	}

	public void setActivarid_tipo_documento_generalParametroGeneral(Boolean activarid_tipo_documento_generalParametroGeneral) {
		this.activarid_tipo_documento_generalParametroGeneral= activarid_tipo_documento_generalParametroGeneral;
	}

	public Boolean getCargarid_tipo_documento_generalParametroGeneral() {
		return this.cargarid_tipo_documento_generalParametroGeneral;
	}

	public void setCargarid_tipo_documento_generalParametroGeneral(Boolean cargarid_tipo_documento_generalParametroGeneral) {
		this.cargarid_tipo_documento_generalParametroGeneral= cargarid_tipo_documento_generalParametroGeneral;
	}

	public Border setResaltarnumero_secuencialParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialParametroGeneral() {
		return this.resaltarnumero_secuencialParametroGeneral;
	}

	public void setResaltarnumero_secuencialParametroGeneral(Border borderResaltar) {
		this.resaltarnumero_secuencialParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialParametroGeneral() {
		return this.mostrarnumero_secuencialParametroGeneral;
	}

	public void setMostrarnumero_secuencialParametroGeneral(Boolean mostrarnumero_secuencialParametroGeneral) {
		this.mostrarnumero_secuencialParametroGeneral= mostrarnumero_secuencialParametroGeneral;
	}

	public Boolean getActivarnumero_secuencialParametroGeneral() {
		return this.activarnumero_secuencialParametroGeneral;
	}

	public void setActivarnumero_secuencialParametroGeneral(Boolean activarnumero_secuencialParametroGeneral) {
		this.activarnumero_secuencialParametroGeneral= activarnumero_secuencialParametroGeneral;
	}

	public Border setResaltarnumero_autorParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarnumero_autorParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorParametroGeneral() {
		return this.resaltarnumero_autorParametroGeneral;
	}

	public void setResaltarnumero_autorParametroGeneral(Border borderResaltar) {
		this.resaltarnumero_autorParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarnumero_autorParametroGeneral() {
		return this.mostrarnumero_autorParametroGeneral;
	}

	public void setMostrarnumero_autorParametroGeneral(Boolean mostrarnumero_autorParametroGeneral) {
		this.mostrarnumero_autorParametroGeneral= mostrarnumero_autorParametroGeneral;
	}

	public Boolean getActivarnumero_autorParametroGeneral() {
		return this.activarnumero_autorParametroGeneral;
	}

	public void setActivarnumero_autorParametroGeneral(Boolean activarnumero_autorParametroGeneral) {
		this.activarnumero_autorParametroGeneral= activarnumero_autorParametroGeneral;
	}

	public Border setResaltarfecha_inicioParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioParametroGeneral() {
		return this.resaltarfecha_inicioParametroGeneral;
	}

	public void setResaltarfecha_inicioParametroGeneral(Border borderResaltar) {
		this.resaltarfecha_inicioParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioParametroGeneral() {
		return this.mostrarfecha_inicioParametroGeneral;
	}

	public void setMostrarfecha_inicioParametroGeneral(Boolean mostrarfecha_inicioParametroGeneral) {
		this.mostrarfecha_inicioParametroGeneral= mostrarfecha_inicioParametroGeneral;
	}

	public Boolean getActivarfecha_inicioParametroGeneral() {
		return this.activarfecha_inicioParametroGeneral;
	}

	public void setActivarfecha_inicioParametroGeneral(Boolean activarfecha_inicioParametroGeneral) {
		this.activarfecha_inicioParametroGeneral= activarfecha_inicioParametroGeneral;
	}

	public Border setResaltarfecha_finParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltarfecha_finParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finParametroGeneral() {
		return this.resaltarfecha_finParametroGeneral;
	}

	public void setResaltarfecha_finParametroGeneral(Border borderResaltar) {
		this.resaltarfecha_finParametroGeneral= borderResaltar;
	}

	public Boolean getMostrarfecha_finParametroGeneral() {
		return this.mostrarfecha_finParametroGeneral;
	}

	public void setMostrarfecha_finParametroGeneral(Boolean mostrarfecha_finParametroGeneral) {
		this.mostrarfecha_finParametroGeneral= mostrarfecha_finParametroGeneral;
	}

	public Boolean getActivarfecha_finParametroGeneral() {
		return this.activarfecha_finParametroGeneral;
	}

	public void setActivarfecha_finParametroGeneral(Boolean activarfecha_finParametroGeneral) {
		this.activarfecha_finParametroGeneral= activarfecha_finParametroGeneral;
	}

	public Border setResaltaresta_activoParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogeneralBeanSwingJInternalFrame.jTtoolBarParametroGeneral.setBorder(borderResaltar);
		
		this.resaltaresta_activoParametroGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoParametroGeneral() {
		return this.resaltaresta_activoParametroGeneral;
	}

	public void setResaltaresta_activoParametroGeneral(Border borderResaltar) {
		this.resaltaresta_activoParametroGeneral= borderResaltar;
	}

	public Boolean getMostraresta_activoParametroGeneral() {
		return this.mostraresta_activoParametroGeneral;
	}

	public void setMostraresta_activoParametroGeneral(Boolean mostraresta_activoParametroGeneral) {
		this.mostraresta_activoParametroGeneral= mostraresta_activoParametroGeneral;
	}

	public Boolean getActivaresta_activoParametroGeneral() {
		return this.activaresta_activoParametroGeneral;
	}

	public void setActivaresta_activoParametroGeneral(Boolean activaresta_activoParametroGeneral) {
		this.activaresta_activoParametroGeneral= activaresta_activoParametroGeneral;
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
		
		
		this.setMostraridParametroGeneral(esInicial);
		this.setMostrarid_empresaParametroGeneral(esInicial);
		this.setMostrarid_sucursalParametroGeneral(esInicial);
		this.setMostrarid_tipo_documento_generalParametroGeneral(esInicial);
		this.setMostrarnumero_secuencialParametroGeneral(esInicial);
		this.setMostrarnumero_autorParametroGeneral(esInicial);
		this.setMostrarfecha_inicioParametroGeneral(esInicial);
		this.setMostrarfecha_finParametroGeneral(esInicial);
		this.setMostraresta_activoParametroGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.ID)) {
				this.setMostraridParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setMostrarid_tipo_documento_generalParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.NUMEROAUTOR)) {
				this.setMostrarnumero_autorParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoParametroGeneral(esAsigna);
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
		
		
		this.setActivaridParametroGeneral(esInicial);
		this.setActivarid_empresaParametroGeneral(esInicial);
		this.setActivarid_sucursalParametroGeneral(esInicial);
		this.setActivarid_tipo_documento_generalParametroGeneral(esInicial);
		this.setActivarnumero_secuencialParametroGeneral(esInicial);
		this.setActivarnumero_autorParametroGeneral(esInicial);
		this.setActivarfecha_inicioParametroGeneral(esInicial);
		this.setActivarfecha_finParametroGeneral(esInicial);
		this.setActivaresta_activoParametroGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.ID)) {
				this.setActivaridParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setActivarid_tipo_documento_generalParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.NUMEROAUTOR)) {
				this.setActivarnumero_autorParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoParametroGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroGeneral(esInicial);
		this.setResaltarid_empresaParametroGeneral(esInicial);
		this.setResaltarid_sucursalParametroGeneral(esInicial);
		this.setResaltarid_tipo_documento_generalParametroGeneral(esInicial);
		this.setResaltarnumero_secuencialParametroGeneral(esInicial);
		this.setResaltarnumero_autorParametroGeneral(esInicial);
		this.setResaltarfecha_inicioParametroGeneral(esInicial);
		this.setResaltarfecha_finParametroGeneral(esInicial);
		this.setResaltaresta_activoParametroGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.ID)) {
				this.setResaltaridParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setResaltarid_tipo_documento_generalParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.NUMEROAUTOR)) {
				this.setResaltarnumero_autorParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finParametroGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGeneralConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoParametroGeneral(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdSucursalParametroGeneral=true;

	public Boolean getMostrarFK_IdSucursalParametroGeneral() {
		return this.mostrarFK_IdSucursalParametroGeneral;
	}

	public void setMostrarFK_IdSucursalParametroGeneral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroGeneral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEmpresaParametroGeneral=true;

	public Boolean getMostrarFK_IdSucursalEmpresaParametroGeneral() {
		return this.mostrarFK_IdSucursalEmpresaParametroGeneral;
	}

	public void setMostrarFK_IdSucursalEmpresaParametroGeneral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEmpresaParametroGeneral= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoGeneralParametroGeneral=true;

	public Boolean getMostrarFK_IdTipoDocumentoGeneralParametroGeneral() {
		return this.mostrarFK_IdTipoDocumentoGeneralParametroGeneral;
	}

	public void setMostrarFK_IdTipoDocumentoGeneralParametroGeneral(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoGeneralParametroGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdSucursalParametroGeneral=true;

	public Boolean getActivarFK_IdSucursalParametroGeneral() {
		return this.activarFK_IdSucursalParametroGeneral;
	}

	public void setActivarFK_IdSucursalParametroGeneral(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroGeneral= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEmpresaParametroGeneral=true;

	public Boolean getActivarFK_IdSucursalEmpresaParametroGeneral() {
		return this.activarFK_IdSucursalEmpresaParametroGeneral;
	}

	public void setActivarFK_IdSucursalEmpresaParametroGeneral(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEmpresaParametroGeneral= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoGeneralParametroGeneral=true;

	public Boolean getActivarFK_IdTipoDocumentoGeneralParametroGeneral() {
		return this.activarFK_IdTipoDocumentoGeneralParametroGeneral;
	}

	public void setActivarFK_IdTipoDocumentoGeneralParametroGeneral(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoGeneralParametroGeneral= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdSucursalParametroGeneral=null;

	public Border getResaltarFK_IdSucursalParametroGeneral() {
		return this.resaltarFK_IdSucursalParametroGeneral;
	}

	public void setResaltarFK_IdSucursalParametroGeneral(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroGeneral= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroGeneral= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEmpresaParametroGeneral=null;

	public Border getResaltarFK_IdSucursalEmpresaParametroGeneral() {
		return this.resaltarFK_IdSucursalEmpresaParametroGeneral;
	}

	public void setResaltarFK_IdSucursalEmpresaParametroGeneral(Border borderResaltar) {
		this.resaltarFK_IdSucursalEmpresaParametroGeneral= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEmpresaParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEmpresaParametroGeneral= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoGeneralParametroGeneral=null;

	public Border getResaltarFK_IdTipoDocumentoGeneralParametroGeneral() {
		return this.resaltarFK_IdTipoDocumentoGeneralParametroGeneral;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralParametroGeneral(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoGeneralParametroGeneral= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGeneralBeanSwingJInternalFrame parametrogeneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoGeneralParametroGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}