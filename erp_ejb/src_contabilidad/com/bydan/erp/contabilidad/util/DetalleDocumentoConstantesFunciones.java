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


import com.bydan.erp.contabilidad.util.DetalleDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleDocumentoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleDocumentoParameterGeneral;

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
final public class DetalleDocumentoConstantesFunciones extends DetalleDocumentoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleDocumento";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleDocumento"+DetalleDocumentoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleDocumentoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleDocumentoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleDocumentoConstantesFunciones.SCHEMA+"_"+DetalleDocumentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleDocumentoConstantesFunciones.SCHEMA+"_"+DetalleDocumentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleDocumentoConstantesFunciones.SCHEMA+"_"+DetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleDocumentoConstantesFunciones.SCHEMA+"_"+DetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleDocumentoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleDocumentoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleDocumentoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleDocumentoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Documentos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Documento";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Documento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleDocumento";
	public static final String OBJECTNAME="detalledocumento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="detalle_documento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalledocumento from "+DetalleDocumentoConstantesFunciones.SPERSISTENCENAME+" detalledocumento";
	public static String QUERYSELECTNATIVE="select "+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".id,"+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".version_row,"+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".id_modulo,"+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".id_tipo_detalle_documento,"+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME+".nombre from "+DetalleDocumentoConstantesFunciones.SCHEMA+"."+DetalleDocumentoConstantesFunciones.TABLENAME;//+" as "+DetalleDocumentoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleDocumentoConstantesFuncionesAdditional detalledocumentoConstantesFuncionesAdditional=null;
	
	public DetalleDocumentoConstantesFuncionesAdditional getDetalleDocumentoConstantesFuncionesAdditional() {
		return this.detalledocumentoConstantesFuncionesAdditional;
	}
	
	public void setDetalleDocumentoConstantesFuncionesAdditional(DetalleDocumentoConstantesFuncionesAdditional detalledocumentoConstantesFuncionesAdditional) {
		try {
			this.detalledocumentoConstantesFuncionesAdditional=detalledocumentoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDTIPODETALLEDOCUMENTO= "id_tipo_detalle_documento";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDTIPODETALLEDOCUMENTO= "T Detalle Documento";
		public static final String LABEL_IDTIPODETALLEDOCUMENTO_LOWER= "Tipo Detalle Documento";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleDocumentoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleDocumentoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleDocumentoConstantesFunciones.IDMODULO)) {sLabelColumna=DetalleDocumentoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=DetalleDocumentoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO)) {sLabelColumna=DetalleDocumentoConstantesFunciones.LABEL_IDTIPODETALLEDOCUMENTO;}
		if(sNombreColumna.equals(DetalleDocumentoConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleDocumentoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getDetalleDocumentoDescripcion(DetalleDocumento detalledocumento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalledocumento !=null/* && detalledocumento.getId()!=0*/) {
			sDescripcion=detalledocumento.getnombre();//detalledocumentodetalledocumento.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleDocumentoDescripcionDetallado(DetalleDocumento detalledocumento) {
		String sDescripcion="";
			
		sDescripcion+=DetalleDocumentoConstantesFunciones.ID+"=";
		sDescripcion+=detalledocumento.getId().toString()+",";
		sDescripcion+=DetalleDocumentoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalledocumento.getVersionRow().toString()+",";
		sDescripcion+=DetalleDocumentoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalledocumento.getid_empresa().toString()+",";
		sDescripcion+=DetalleDocumentoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=detalledocumento.getid_modulo().toString()+",";
		sDescripcion+=DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=detalledocumento.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO+"=";
		sDescripcion+=detalledocumento.getid_tipo_detalle_documento().toString()+",";
		sDescripcion+=DetalleDocumentoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detalledocumento.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleDocumentoDescripcion(DetalleDocumento detalledocumento,String sValor) throws Exception {			
		if(detalledocumento !=null) {
			detalledocumento.setnombre(sValor);;//detalledocumentodetalledocumento.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getTipoDetalleDocumentoDescripcion(TipoDetalleDocumento tipodetalledocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodetalledocumento!=null/*&&tipodetalledocumento.getId()>0*/) {
			sDescripcion=TipoDetalleDocumentoConstantesFunciones.getTipoDetalleDocumentoDescripcion(tipodetalledocumento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdModuloPorIdTipoTransaccion")) {
			sNombreIndice="Tipo=  Por Modulo Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdDetalleDocumento")) {
			sNombreIndice="Tipo=  Por T Detalle Documento";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdModuloPorIdTipoTransaccion(Long id_modulo,Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleDocumento(Long id_tipo_detalle_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_detalle_documento!=null) {sDetalleIndice+=" Codigo Unico De T Detalle Documento="+id_tipo_detalle_documento.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleDocumento(DetalleDocumento detalledocumento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalledocumento.setnombre(detalledocumento.getnombre().trim());
	}
	
	public static void quitarEspaciosDetalleDocumentos(List<DetalleDocumento> detalledocumentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleDocumento detalledocumento: detalledocumentos) {
			detalledocumento.setnombre(detalledocumento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleDocumento(DetalleDocumento detalledocumento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalledocumento.getConCambioAuxiliar()) {
			detalledocumento.setIsDeleted(detalledocumento.getIsDeletedAuxiliar());	
			detalledocumento.setIsNew(detalledocumento.getIsNewAuxiliar());	
			detalledocumento.setIsChanged(detalledocumento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalledocumento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalledocumento.setIsDeletedAuxiliar(false);	
			detalledocumento.setIsNewAuxiliar(false);	
			detalledocumento.setIsChangedAuxiliar(false);
			
			detalledocumento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleDocumentos(List<DetalleDocumento> detalledocumentos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleDocumento detalledocumento : detalledocumentos) {
			if(conAsignarBase && detalledocumento.getConCambioAuxiliar()) {
				detalledocumento.setIsDeleted(detalledocumento.getIsDeletedAuxiliar());	
				detalledocumento.setIsNew(detalledocumento.getIsNewAuxiliar());	
				detalledocumento.setIsChanged(detalledocumento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalledocumento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalledocumento.setIsDeletedAuxiliar(false);	
				detalledocumento.setIsNewAuxiliar(false);	
				detalledocumento.setIsChangedAuxiliar(false);
				
				detalledocumento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleDocumento(DetalleDocumento detalledocumento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleDocumentos(List<DetalleDocumento> detalledocumentos,Boolean conEnteros) throws Exception  {
		
		for(DetalleDocumento detalledocumento: detalledocumentos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleDocumento(List<DetalleDocumento> detalledocumentos,DetalleDocumento detalledocumentoAux) throws Exception  {
		DetalleDocumentoConstantesFunciones.InicializarValoresDetalleDocumento(detalledocumentoAux,true);
		
		for(DetalleDocumento detalledocumento: detalledocumentos) {
			if(detalledocumento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleDocumento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleDocumentoConstantesFunciones.getArrayColumnasGlobalesDetalleDocumento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleDocumento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleDocumentoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleDocumentoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleDocumentoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleDocumento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleDocumentoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleDocumento> detalledocumentos,DetalleDocumento detalledocumento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleDocumento detalledocumentoAux: detalledocumentos) {
			if(detalledocumentoAux!=null && detalledocumento!=null) {
				if((detalledocumentoAux.getId()==null && detalledocumento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalledocumentoAux.getId()!=null && detalledocumento.getId()!=null){
					if(detalledocumentoAux.getId().equals(detalledocumento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleDocumento(List<DetalleDocumento> detalledocumentos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleDocumento detalledocumento: detalledocumentos) {			
			if(detalledocumento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleDocumento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_ID, DetalleDocumentoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_VERSIONROW, DetalleDocumentoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA, DetalleDocumentoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_IDMODULO, DetalleDocumentoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_IDTIPODETALLEDOCUMENTO, DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleDocumentoConstantesFunciones.LABEL_NOMBRE, DetalleDocumentoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleDocumento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleDocumentoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleDocumento() throws Exception  {
		return DetalleDocumentoConstantesFunciones.getTiposSeleccionarDetalleDocumento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleDocumento(Boolean conFk) throws Exception  {
		return DetalleDocumentoConstantesFunciones.getTiposSeleccionarDetalleDocumento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleDocumento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDocumentoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DetalleDocumentoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDocumentoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(DetalleDocumentoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDocumentoConstantesFunciones.LABEL_IDTIPODETALLEDOCUMENTO);
			reporte.setsDescripcion(DetalleDocumentoConstantesFunciones.LABEL_IDTIPODETALLEDOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleDocumentoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleDocumentoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleDocumento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleDocumento(DetalleDocumento detalledocumentoAux) throws Exception {
		
			detalledocumentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalledocumentoAux.getEmpresa()));
			detalledocumentoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalledocumentoAux.getModulo()));
			detalledocumentoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalledocumentoAux.getTipoTransaccionModulo()));
			detalledocumentoAux.settipodetalledocumento_descripcion(TipoDetalleDocumentoConstantesFunciones.getTipoDetalleDocumentoDescripcion(detalledocumentoAux.getTipoDetalleDocumento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleDocumento(List<DetalleDocumento> detalledocumentosTemp) throws Exception {
		for(DetalleDocumento detalledocumentoAux:detalledocumentosTemp) {
			
			detalledocumentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalledocumentoAux.getEmpresa()));
			detalledocumentoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalledocumentoAux.getModulo()));
			detalledocumentoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalledocumentoAux.getTipoTransaccionModulo()));
			detalledocumentoAux.settipodetalledocumento_descripcion(TipoDetalleDocumentoConstantesFunciones.getTipoDetalleDocumentoDescripcion(detalledocumentoAux.getTipoDetalleDocumento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(TipoDetalleDocumento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDetalleDocumento.class)) {
						classes.add(new Classe(TipoDetalleDocumento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(TipoDetalleDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetalleDocumento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(TipoDetalleDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetalleDocumento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleDocumentoConstantesFunciones.getClassesRelationshipsOfDetalleDocumento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleDocumentoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleDocumento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleDocumento detalledocumento,List<DetalleDocumento> detalledocumentos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleDocumento detalledocumentoEncontrado=null;
			
			for(DetalleDocumento detalledocumentoLocal:detalledocumentos) {
				if(detalledocumentoLocal.getId().equals(detalledocumento.getId())) {
					detalledocumentoEncontrado=detalledocumentoLocal;
					
					detalledocumentoLocal.setIsChanged(detalledocumento.getIsChanged());
					detalledocumentoLocal.setIsNew(detalledocumento.getIsNew());
					detalledocumentoLocal.setIsDeleted(detalledocumento.getIsDeleted());
					
					detalledocumentoLocal.setGeneralEntityOriginal(detalledocumento.getGeneralEntityOriginal());
					
					detalledocumentoLocal.setId(detalledocumento.getId());	
					detalledocumentoLocal.setVersionRow(detalledocumento.getVersionRow());	
					detalledocumentoLocal.setid_empresa(detalledocumento.getid_empresa());	
					detalledocumentoLocal.setid_modulo(detalledocumento.getid_modulo());	
					detalledocumentoLocal.setid_tipo_transaccion_modulo(detalledocumento.getid_tipo_transaccion_modulo());	
					detalledocumentoLocal.setid_tipo_detalle_documento(detalledocumento.getid_tipo_detalle_documento());	
					detalledocumentoLocal.setnombre(detalledocumento.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalledocumento.getIsDeleted()) {
				if(!existe) {
					detalledocumentos.add(detalledocumento);
				}
			} else {
				if(detalledocumentoEncontrado!=null && permiteQuitar)  {
					detalledocumentos.remove(detalledocumentoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleDocumento detalledocumento,List<DetalleDocumento> detalledocumentos) throws Exception {
		try	{			
			for(DetalleDocumento detalledocumentoLocal:detalledocumentos) {
				if(detalledocumentoLocal.getId().equals(detalledocumento.getId())) {
					detalledocumentoLocal.setIsSelected(detalledocumento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleDocumento(List<DetalleDocumento> detalledocumentosAux) throws Exception {
		//this.detalledocumentosAux=detalledocumentosAux;
		
		for(DetalleDocumento detalledocumentoAux:detalledocumentosAux) {
			if(detalledocumentoAux.getIsChanged()) {
				detalledocumentoAux.setIsChanged(false);
			}		
			
			if(detalledocumentoAux.getIsNew()) {
				detalledocumentoAux.setIsNew(false);
			}	
			
			if(detalledocumentoAux.getIsDeleted()) {
				detalledocumentoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleDocumento(DetalleDocumento detalledocumentoAux) throws Exception {
		//this.detalledocumentoAux=detalledocumentoAux;
		
			if(detalledocumentoAux.getIsChanged()) {
				detalledocumentoAux.setIsChanged(false);
			}		
			
			if(detalledocumentoAux.getIsNew()) {
				detalledocumentoAux.setIsNew(false);
			}	
			
			if(detalledocumentoAux.getIsDeleted()) {
				detalledocumentoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleDocumento detalledocumentoAsignar,DetalleDocumento detalledocumento) throws Exception {
		detalledocumentoAsignar.setId(detalledocumento.getId());	
		detalledocumentoAsignar.setVersionRow(detalledocumento.getVersionRow());	
		detalledocumentoAsignar.setid_empresa(detalledocumento.getid_empresa());
		detalledocumentoAsignar.setempresa_descripcion(detalledocumento.getempresa_descripcion());	
		detalledocumentoAsignar.setid_modulo(detalledocumento.getid_modulo());
		detalledocumentoAsignar.setmodulo_descripcion(detalledocumento.getmodulo_descripcion());	
		detalledocumentoAsignar.setid_tipo_transaccion_modulo(detalledocumento.getid_tipo_transaccion_modulo());
		detalledocumentoAsignar.settipotransaccionmodulo_descripcion(detalledocumento.gettipotransaccionmodulo_descripcion());	
		detalledocumentoAsignar.setid_tipo_detalle_documento(detalledocumento.getid_tipo_detalle_documento());
		detalledocumentoAsignar.settipodetalledocumento_descripcion(detalledocumento.gettipodetalledocumento_descripcion());	
		detalledocumentoAsignar.setnombre(detalledocumento.getnombre());	
	}
	
	public static void inicializarDetalleDocumento(DetalleDocumento detalledocumento) throws Exception {
		try {
				detalledocumento.setId(0L);	
					
				detalledocumento.setid_empresa(-1L);	
				detalledocumento.setid_modulo(-1L);	
				detalledocumento.setid_tipo_transaccion_modulo(null);	
				detalledocumento.setid_tipo_detalle_documento(-1L);	
				detalledocumento.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleDocumento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDocumentoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDocumentoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDocumentoConstantesFunciones.LABEL_IDTIPODETALLEDOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleDocumentoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleDocumento(String sTipo,Row row,Workbook workbook,DetalleDocumento detalledocumento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledocumento.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledocumento.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledocumento.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledocumento.gettipodetalledocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalledocumento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleDocumento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleDocumento() {
		return this.sFinalQueryDetalleDocumento;
	}
	
	public void setsFinalQueryDetalleDocumento(String sFinalQueryDetalleDocumento) {
		this.sFinalQueryDetalleDocumento= sFinalQueryDetalleDocumento;
	}
	
	public Border resaltarSeleccionarDetalleDocumento=null;
	
	public Border setResaltarSeleccionarDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleDocumento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleDocumento() {
		return this.resaltarSeleccionarDetalleDocumento;
	}
	
	public void setResaltarSeleccionarDetalleDocumento(Border borderResaltarSeleccionarDetalleDocumento) {
		this.resaltarSeleccionarDetalleDocumento= borderResaltarSeleccionarDetalleDocumento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleDocumento=null;
	public Boolean mostraridDetalleDocumento=true;
	public Boolean activaridDetalleDocumento=true;

	public Border resaltarid_empresaDetalleDocumento=null;
	public Boolean mostrarid_empresaDetalleDocumento=true;
	public Boolean activarid_empresaDetalleDocumento=true;
	public Boolean cargarid_empresaDetalleDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleDocumento=false;//ConEventDepend=true

	public Border resaltarid_moduloDetalleDocumento=null;
	public Boolean mostrarid_moduloDetalleDocumento=true;
	public Boolean activarid_moduloDetalleDocumento=true;
	public Boolean cargarid_moduloDetalleDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDetalleDocumento=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloDetalleDocumento=null;
	public Boolean mostrarid_tipo_transaccion_moduloDetalleDocumento=true;
	public Boolean activarid_tipo_transaccion_moduloDetalleDocumento=false;
	public Boolean cargarid_tipo_transaccion_moduloDetalleDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloDetalleDocumento=true;//ConEventDepend=true

	public Border resaltarid_tipo_detalle_documentoDetalleDocumento=null;
	public Boolean mostrarid_tipo_detalle_documentoDetalleDocumento=true;
	public Boolean activarid_tipo_detalle_documentoDetalleDocumento=true;
	public Boolean cargarid_tipo_detalle_documentoDetalleDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_detalle_documentoDetalleDocumento=false;//ConEventDepend=true

	public Border resaltarnombreDetalleDocumento=null;
	public Boolean mostrarnombreDetalleDocumento=true;
	public Boolean activarnombreDetalleDocumento=true;

	
	

	public Border setResaltaridDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltaridDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleDocumento() {
		return this.resaltaridDetalleDocumento;
	}

	public void setResaltaridDetalleDocumento(Border borderResaltar) {
		this.resaltaridDetalleDocumento= borderResaltar;
	}

	public Boolean getMostraridDetalleDocumento() {
		return this.mostraridDetalleDocumento;
	}

	public void setMostraridDetalleDocumento(Boolean mostraridDetalleDocumento) {
		this.mostraridDetalleDocumento= mostraridDetalleDocumento;
	}

	public Boolean getActivaridDetalleDocumento() {
		return this.activaridDetalleDocumento;
	}

	public void setActivaridDetalleDocumento(Boolean activaridDetalleDocumento) {
		this.activaridDetalleDocumento= activaridDetalleDocumento;
	}

	public Border setResaltarid_empresaDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleDocumento() {
		return this.resaltarid_empresaDetalleDocumento;
	}

	public void setResaltarid_empresaDetalleDocumento(Border borderResaltar) {
		this.resaltarid_empresaDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleDocumento() {
		return this.mostrarid_empresaDetalleDocumento;
	}

	public void setMostrarid_empresaDetalleDocumento(Boolean mostrarid_empresaDetalleDocumento) {
		this.mostrarid_empresaDetalleDocumento= mostrarid_empresaDetalleDocumento;
	}

	public Boolean getActivarid_empresaDetalleDocumento() {
		return this.activarid_empresaDetalleDocumento;
	}

	public void setActivarid_empresaDetalleDocumento(Boolean activarid_empresaDetalleDocumento) {
		this.activarid_empresaDetalleDocumento= activarid_empresaDetalleDocumento;
	}

	public Boolean getCargarid_empresaDetalleDocumento() {
		return this.cargarid_empresaDetalleDocumento;
	}

	public void setCargarid_empresaDetalleDocumento(Boolean cargarid_empresaDetalleDocumento) {
		this.cargarid_empresaDetalleDocumento= cargarid_empresaDetalleDocumento;
	}

	public Border setResaltarid_moduloDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarid_moduloDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDetalleDocumento() {
		return this.resaltarid_moduloDetalleDocumento;
	}

	public void setResaltarid_moduloDetalleDocumento(Border borderResaltar) {
		this.resaltarid_moduloDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarid_moduloDetalleDocumento() {
		return this.mostrarid_moduloDetalleDocumento;
	}

	public void setMostrarid_moduloDetalleDocumento(Boolean mostrarid_moduloDetalleDocumento) {
		this.mostrarid_moduloDetalleDocumento= mostrarid_moduloDetalleDocumento;
	}

	public Boolean getActivarid_moduloDetalleDocumento() {
		return this.activarid_moduloDetalleDocumento;
	}

	public void setActivarid_moduloDetalleDocumento(Boolean activarid_moduloDetalleDocumento) {
		this.activarid_moduloDetalleDocumento= activarid_moduloDetalleDocumento;
	}

	public Boolean getCargarid_moduloDetalleDocumento() {
		return this.cargarid_moduloDetalleDocumento;
	}

	public void setCargarid_moduloDetalleDocumento(Boolean cargarid_moduloDetalleDocumento) {
		this.cargarid_moduloDetalleDocumento= cargarid_moduloDetalleDocumento;
	}

	public Border setResaltarid_tipo_transaccion_moduloDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloDetalleDocumento() {
		return this.resaltarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public void setResaltarid_tipo_transaccion_moduloDetalleDocumento(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloDetalleDocumento() {
		return this.mostrarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public void setMostrarid_tipo_transaccion_moduloDetalleDocumento(Boolean mostrarid_tipo_transaccion_moduloDetalleDocumento) {
		this.mostrarid_tipo_transaccion_moduloDetalleDocumento= mostrarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public Boolean getActivarid_tipo_transaccion_moduloDetalleDocumento() {
		return this.activarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public void setActivarid_tipo_transaccion_moduloDetalleDocumento(Boolean activarid_tipo_transaccion_moduloDetalleDocumento) {
		this.activarid_tipo_transaccion_moduloDetalleDocumento= activarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public Boolean getCargarid_tipo_transaccion_moduloDetalleDocumento() {
		return this.cargarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public void setCargarid_tipo_transaccion_moduloDetalleDocumento(Boolean cargarid_tipo_transaccion_moduloDetalleDocumento) {
		this.cargarid_tipo_transaccion_moduloDetalleDocumento= cargarid_tipo_transaccion_moduloDetalleDocumento;
	}

	public Border setResaltarid_tipo_detalle_documentoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarid_tipo_detalle_documentoDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_detalle_documentoDetalleDocumento() {
		return this.resaltarid_tipo_detalle_documentoDetalleDocumento;
	}

	public void setResaltarid_tipo_detalle_documentoDetalleDocumento(Border borderResaltar) {
		this.resaltarid_tipo_detalle_documentoDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarid_tipo_detalle_documentoDetalleDocumento() {
		return this.mostrarid_tipo_detalle_documentoDetalleDocumento;
	}

	public void setMostrarid_tipo_detalle_documentoDetalleDocumento(Boolean mostrarid_tipo_detalle_documentoDetalleDocumento) {
		this.mostrarid_tipo_detalle_documentoDetalleDocumento= mostrarid_tipo_detalle_documentoDetalleDocumento;
	}

	public Boolean getActivarid_tipo_detalle_documentoDetalleDocumento() {
		return this.activarid_tipo_detalle_documentoDetalleDocumento;
	}

	public void setActivarid_tipo_detalle_documentoDetalleDocumento(Boolean activarid_tipo_detalle_documentoDetalleDocumento) {
		this.activarid_tipo_detalle_documentoDetalleDocumento= activarid_tipo_detalle_documentoDetalleDocumento;
	}

	public Boolean getCargarid_tipo_detalle_documentoDetalleDocumento() {
		return this.cargarid_tipo_detalle_documentoDetalleDocumento;
	}

	public void setCargarid_tipo_detalle_documentoDetalleDocumento(Boolean cargarid_tipo_detalle_documentoDetalleDocumento) {
		this.cargarid_tipo_detalle_documentoDetalleDocumento= cargarid_tipo_detalle_documentoDetalleDocumento;
	}

	public Border setResaltarnombreDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalledocumentoBeanSwingJInternalFrame.jTtoolBarDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleDocumento() {
		return this.resaltarnombreDetalleDocumento;
	}

	public void setResaltarnombreDetalleDocumento(Border borderResaltar) {
		this.resaltarnombreDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleDocumento() {
		return this.mostrarnombreDetalleDocumento;
	}

	public void setMostrarnombreDetalleDocumento(Boolean mostrarnombreDetalleDocumento) {
		this.mostrarnombreDetalleDocumento= mostrarnombreDetalleDocumento;
	}

	public Boolean getActivarnombreDetalleDocumento() {
		return this.activarnombreDetalleDocumento;
	}

	public void setActivarnombreDetalleDocumento(Boolean activarnombreDetalleDocumento) {
		this.activarnombreDetalleDocumento= activarnombreDetalleDocumento;
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
		
		
		this.setMostraridDetalleDocumento(esInicial);
		this.setMostrarid_empresaDetalleDocumento(esInicial);
		this.setMostrarid_moduloDetalleDocumento(esInicial);
		this.setMostrarid_tipo_transaccion_moduloDetalleDocumento(esInicial);
		this.setMostrarid_tipo_detalle_documentoDetalleDocumento(esInicial);
		this.setMostrarnombreDetalleDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.ID)) {
				this.setMostraridDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO)) {
				this.setMostrarid_tipo_detalle_documentoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleDocumento(esAsigna);
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
		
		
		this.setActivaridDetalleDocumento(esInicial);
		this.setActivarid_empresaDetalleDocumento(esInicial);
		this.setActivarid_moduloDetalleDocumento(esInicial);
		this.setActivarid_tipo_transaccion_moduloDetalleDocumento(esInicial);
		this.setActivarid_tipo_detalle_documentoDetalleDocumento(esInicial);
		this.setActivarnombreDetalleDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.ID)) {
				this.setActivaridDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO)) {
				this.setActivarid_tipo_detalle_documentoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleDocumento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleDocumento(esInicial);
		this.setResaltarid_empresaDetalleDocumento(esInicial);
		this.setResaltarid_moduloDetalleDocumento(esInicial);
		this.setResaltarid_tipo_transaccion_moduloDetalleDocumento(esInicial);
		this.setResaltarid_tipo_detalle_documentoDetalleDocumento(esInicial);
		this.setResaltarnombreDetalleDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.ID)) {
				this.setResaltaridDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO)) {
				this.setResaltarid_tipo_detalle_documentoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleDocumentoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleDocumento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento=true;

	public Boolean getMostrarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento() {
		return this.mostrarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento;
	}

	public void setMostrarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleDocumentoDetalleDocumento=true;

	public Boolean getMostrarFK_IdDetalleDocumentoDetalleDocumento() {
		return this.mostrarFK_IdDetalleDocumentoDetalleDocumento;
	}

	public void setMostrarFK_IdDetalleDocumentoDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleDocumentoDetalleDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleDocumento=true;

	public Boolean getMostrarFK_IdEmpresaDetalleDocumento() {
		return this.mostrarFK_IdEmpresaDetalleDocumento;
	}

	public void setMostrarFK_IdEmpresaDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDetalleDocumento=true;

	public Boolean getMostrarFK_IdModuloDetalleDocumento() {
		return this.mostrarFK_IdModuloDetalleDocumento;
	}

	public void setMostrarFK_IdModuloDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDetalleDocumento= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento=true;

	public Boolean getActivarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento() {
		return this.activarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento;
	}

	public void setActivarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleDocumentoDetalleDocumento=true;

	public Boolean getActivarFK_IdDetalleDocumentoDetalleDocumento() {
		return this.activarFK_IdDetalleDocumentoDetalleDocumento;
	}

	public void setActivarFK_IdDetalleDocumentoDetalleDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleDocumentoDetalleDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleDocumento=true;

	public Boolean getActivarFK_IdEmpresaDetalleDocumento() {
		return this.activarFK_IdEmpresaDetalleDocumento;
	}

	public void setActivarFK_IdEmpresaDetalleDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDetalleDocumento=true;

	public Boolean getActivarFK_IdModuloDetalleDocumento() {
		return this.activarFK_IdModuloDetalleDocumento;
	}

	public void setActivarFK_IdModuloDetalleDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDetalleDocumento= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento=null;

	public Border getResaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento() {
		return this.resaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento;
	}

	public void setResaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento(Border borderResaltar) {
		this.resaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento= borderResaltar;
	}

	public void setResaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdModuloPorIdTipoTransaccionDetalleDocumento= borderResaltar;
	}

	public Border resaltarFK_IdDetalleDocumentoDetalleDocumento=null;

	public Border getResaltarFK_IdDetalleDocumentoDetalleDocumento() {
		return this.resaltarFK_IdDetalleDocumentoDetalleDocumento;
	}

	public void setResaltarFK_IdDetalleDocumentoDetalleDocumento(Border borderResaltar) {
		this.resaltarFK_IdDetalleDocumentoDetalleDocumento= borderResaltar;
	}

	public void setResaltarFK_IdDetalleDocumentoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleDocumentoDetalleDocumento= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleDocumento=null;

	public Border getResaltarFK_IdEmpresaDetalleDocumento() {
		return this.resaltarFK_IdEmpresaDetalleDocumento;
	}

	public void setResaltarFK_IdEmpresaDetalleDocumento(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleDocumento= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleDocumento= borderResaltar;
	}

	public Border resaltarFK_IdModuloDetalleDocumento=null;

	public Border getResaltarFK_IdModuloDetalleDocumento() {
		return this.resaltarFK_IdModuloDetalleDocumento;
	}

	public void setResaltarFK_IdModuloDetalleDocumento(Border borderResaltar) {
		this.resaltarFK_IdModuloDetalleDocumento= borderResaltar;
	}

	public void setResaltarFK_IdModuloDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleDocumentoBeanSwingJInternalFrame detalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDetalleDocumento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}