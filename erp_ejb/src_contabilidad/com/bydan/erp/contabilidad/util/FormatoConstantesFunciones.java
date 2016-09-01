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


import com.bydan.erp.contabilidad.util.FormatoConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormatoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormatoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormatoConstantesFunciones extends FormatoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Formato";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Formato"+FormatoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormatoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormatoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormatoConstantesFunciones.SCHEMA+"_"+FormatoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormatoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormatoConstantesFunciones.SCHEMA+"_"+FormatoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormatoConstantesFunciones.SCHEMA+"_"+FormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormatoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormatoConstantesFunciones.SCHEMA+"_"+FormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormatoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormatoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormatoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormatoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormatoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formatoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Formato";
	public static final String SCLASSWEBTITULO_LOWER="Formato";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Formato";
	public static final String OBJECTNAME="formato";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="formato";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formato from "+FormatoConstantesFunciones.SPERSISTENCENAME+" formato";
	public static String QUERYSELECTNATIVE="select "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".version_row,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_empresa,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_modulo,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".nombre,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_tipo_formato,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".ubicacion from "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME;//+" as "+FormatoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormatoConstantesFuncionesAdditional formatoConstantesFuncionesAdditional=null;
	
	public FormatoConstantesFuncionesAdditional getFormatoConstantesFuncionesAdditional() {
		return this.formatoConstantesFuncionesAdditional;
	}
	
	public void setFormatoConstantesFuncionesAdditional(FormatoConstantesFuncionesAdditional formatoConstantesFuncionesAdditional) {
		try {
			this.formatoConstantesFuncionesAdditional=formatoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPOFORMATO= "id_tipo_formato";
    public static final String UBICACION= "ubicacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPOFORMATO= "Tipo Formato";
		public static final String LABEL_IDTIPOFORMATO_LOWER= "Tipo Formato";
    	public static final String LABEL_UBICACION= "Ubicacion";
		public static final String LABEL_UBICACION_LOWER= "Ubicacion";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXUBICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUBICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFormatoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormatoConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormatoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormatoConstantesFunciones.IDMODULO)) {sLabelColumna=FormatoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(FormatoConstantesFunciones.NOMBRE)) {sLabelColumna=FormatoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FormatoConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=FormatoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(FormatoConstantesFunciones.IDTIPOFORMATO)) {sLabelColumna=FormatoConstantesFunciones.LABEL_IDTIPOFORMATO;}
		if(sNombreColumna.equals(FormatoConstantesFunciones.UBICACION)) {sLabelColumna=FormatoConstantesFunciones.LABEL_UBICACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formato !=null/* && formato.getId()!=0*/) {
			sDescripcion=formato.getnombre();//formatoformato.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFormatoDescripcionDetallado(Formato formato) {
		String sDescripcion="";
			
		sDescripcion+=FormatoConstantesFunciones.ID+"=";
		sDescripcion+=formato.getId().toString()+",";
		sDescripcion+=FormatoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formato.getVersionRow().toString()+",";
		sDescripcion+=FormatoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formato.getid_empresa().toString()+",";
		sDescripcion+=FormatoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=formato.getid_modulo().toString()+",";
		sDescripcion+=FormatoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=formato.getnombre()+",";
		sDescripcion+=FormatoConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=formato.getid_tipo_movimiento().toString()+",";
		sDescripcion+=FormatoConstantesFunciones.IDTIPOFORMATO+"=";
		sDescripcion+=formato.getid_tipo_formato().toString()+",";
		sDescripcion+=FormatoConstantesFunciones.UBICACION+"=";
		sDescripcion+=formato.getubicacion()+",";
			
		return sDescripcion;
	}
	
	public static void setFormatoDescripcion(Formato formato,String sValor) throws Exception {			
		if(formato !=null) {
			formato.setnombre(sValor);;//formatoformato.getnombre().trim();
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

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}

	public static String getTipoFormatoDescripcion(TipoFormato tipoformato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformato!=null/*&&tipoformato.getId()>0*/) {
			sDescripcion=TipoFormatoConstantesFunciones.getTipoFormatoDescripcion(tipoformato);
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
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoFormato")) {
			sNombreIndice="Tipo=  Por Tipo Formato";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("PorEmpresaPorModuloPorTipoFormato")) {
			sNombreIndice="Tipo=  Por Empresa Por Modulo Por Tipo Formato";
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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormato(Long id_tipo_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_formato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Formato="+id_tipo_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorModuloPorTipoFormato(Long id_empresa,Long id_modulo,Long id_tipo_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_formato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Formato="+id_tipo_formato.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormato(Formato formato,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formato.setnombre(formato.getnombre().trim());
		formato.setubicacion(formato.getubicacion().trim());
	}
	
	public static void quitarEspaciosFormatos(List<Formato> formatos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Formato formato: formatos) {
			formato.setnombre(formato.getnombre().trim());
			formato.setubicacion(formato.getubicacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormato(Formato formato,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formato.getConCambioAuxiliar()) {
			formato.setIsDeleted(formato.getIsDeletedAuxiliar());	
			formato.setIsNew(formato.getIsNewAuxiliar());	
			formato.setIsChanged(formato.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formato.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formato.setIsDeletedAuxiliar(false);	
			formato.setIsNewAuxiliar(false);	
			formato.setIsChangedAuxiliar(false);
			
			formato.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormatos(List<Formato> formatos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Formato formato : formatos) {
			if(conAsignarBase && formato.getConCambioAuxiliar()) {
				formato.setIsDeleted(formato.getIsDeletedAuxiliar());	
				formato.setIsNew(formato.getIsNewAuxiliar());	
				formato.setIsChanged(formato.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formato.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formato.setIsDeletedAuxiliar(false);	
				formato.setIsNewAuxiliar(false);	
				formato.setIsChangedAuxiliar(false);
				
				formato.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormato(Formato formato,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormatos(List<Formato> formatos,Boolean conEnteros) throws Exception  {
		
		for(Formato formato: formatos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormato(List<Formato> formatos,Formato formatoAux) throws Exception  {
		FormatoConstantesFunciones.InicializarValoresFormato(formatoAux,true);
		
		for(Formato formato: formatos) {
			if(formato.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormatoConstantesFunciones.getArrayColumnasGlobalesFormato(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormato(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormatoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormatoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FormatoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Formato> formatos,Formato formato,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Formato formatoAux: formatos) {
			if(formatoAux!=null && formato!=null) {
				if((formatoAux.getId()==null && formato.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formatoAux.getId()!=null && formato.getId()!=null){
					if(formatoAux.getId().equals(formato.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormato(List<Formato> formatos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Formato formato: formatos) {			
			if(formato.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormato() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_ID, FormatoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_VERSIONROW, FormatoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_IDEMPRESA, FormatoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_IDMODULO, FormatoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_NOMBRE, FormatoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, FormatoConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_IDTIPOFORMATO, FormatoConstantesFunciones.IDTIPOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormatoConstantesFunciones.LABEL_UBICACION, FormatoConstantesFunciones.UBICACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormato() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.IDTIPOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormatoConstantesFunciones.UBICACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormato() throws Exception  {
		return FormatoConstantesFunciones.getTiposSeleccionarFormato(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormato(Boolean conFk) throws Exception  {
		return FormatoConstantesFunciones.getTiposSeleccionarFormato(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormato(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormatoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(FormatoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FormatoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(FormatoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoConstantesFunciones.LABEL_IDTIPOFORMATO);
			reporte.setsDescripcion(FormatoConstantesFunciones.LABEL_IDTIPOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormatoConstantesFunciones.LABEL_UBICACION);
			reporte.setsDescripcion(FormatoConstantesFunciones.LABEL_UBICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormato(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormato(Formato formatoAux) throws Exception {
		
			formatoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatoAux.getEmpresa()));
			formatoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(formatoAux.getModulo()));
			formatoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(formatoAux.getTipoMovimiento()));
			formatoAux.settipoformato_descripcion(TipoFormatoConstantesFunciones.getTipoFormatoDescripcion(formatoAux.getTipoFormato()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormato(List<Formato> formatosTemp) throws Exception {
		for(Formato formatoAux:formatosTemp) {
			
			formatoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formatoAux.getEmpresa()));
			formatoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(formatoAux.getModulo()));
			formatoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(formatoAux.getTipoMovimiento()));
			formatoAux.settipoformato_descripcion(TipoFormatoConstantesFunciones.getTipoFormatoDescripcion(formatoAux.getTipoFormato()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoFormato.class));
				
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
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormato.class)) {
						classes.add(new Classe(TipoFormato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormato(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoFormato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormato.class)); continue;
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoFormato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoConstantesFunciones.getClassesRelationshipsOfFormato(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormato(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormato(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormatoConstantesFunciones.getClassesRelationshipsFromStringsOfFormato(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormato(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Formato formato,List<Formato> formatos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Formato formatoEncontrado=null;
			
			for(Formato formatoLocal:formatos) {
				if(formatoLocal.getId().equals(formato.getId())) {
					formatoEncontrado=formatoLocal;
					
					formatoLocal.setIsChanged(formato.getIsChanged());
					formatoLocal.setIsNew(formato.getIsNew());
					formatoLocal.setIsDeleted(formato.getIsDeleted());
					
					formatoLocal.setGeneralEntityOriginal(formato.getGeneralEntityOriginal());
					
					formatoLocal.setId(formato.getId());	
					formatoLocal.setVersionRow(formato.getVersionRow());	
					formatoLocal.setid_empresa(formato.getid_empresa());	
					formatoLocal.setid_modulo(formato.getid_modulo());	
					formatoLocal.setnombre(formato.getnombre());	
					formatoLocal.setid_tipo_movimiento(formato.getid_tipo_movimiento());	
					formatoLocal.setid_tipo_formato(formato.getid_tipo_formato());	
					formatoLocal.setubicacion(formato.getubicacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formato.getIsDeleted()) {
				if(!existe) {
					formatos.add(formato);
				}
			} else {
				if(formatoEncontrado!=null && permiteQuitar)  {
					formatos.remove(formatoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Formato formato,List<Formato> formatos) throws Exception {
		try	{			
			for(Formato formatoLocal:formatos) {
				if(formatoLocal.getId().equals(formato.getId())) {
					formatoLocal.setIsSelected(formato.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormato(List<Formato> formatosAux) throws Exception {
		//this.formatosAux=formatosAux;
		
		for(Formato formatoAux:formatosAux) {
			if(formatoAux.getIsChanged()) {
				formatoAux.setIsChanged(false);
			}		
			
			if(formatoAux.getIsNew()) {
				formatoAux.setIsNew(false);
			}	
			
			if(formatoAux.getIsDeleted()) {
				formatoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormato(Formato formatoAux) throws Exception {
		//this.formatoAux=formatoAux;
		
			if(formatoAux.getIsChanged()) {
				formatoAux.setIsChanged(false);
			}		
			
			if(formatoAux.getIsNew()) {
				formatoAux.setIsNew(false);
			}	
			
			if(formatoAux.getIsDeleted()) {
				formatoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Formato formatoAsignar,Formato formato) throws Exception {
		formatoAsignar.setId(formato.getId());	
		formatoAsignar.setVersionRow(formato.getVersionRow());	
		formatoAsignar.setid_empresa(formato.getid_empresa());
		formatoAsignar.setempresa_descripcion(formato.getempresa_descripcion());	
		formatoAsignar.setid_modulo(formato.getid_modulo());
		formatoAsignar.setmodulo_descripcion(formato.getmodulo_descripcion());	
		formatoAsignar.setnombre(formato.getnombre());	
		formatoAsignar.setid_tipo_movimiento(formato.getid_tipo_movimiento());
		formatoAsignar.settipomovimiento_descripcion(formato.gettipomovimiento_descripcion());	
		formatoAsignar.setid_tipo_formato(formato.getid_tipo_formato());
		formatoAsignar.settipoformato_descripcion(formato.gettipoformato_descripcion());	
		formatoAsignar.setubicacion(formato.getubicacion());	
	}
	
	public static void inicializarFormato(Formato formato) throws Exception {
		try {
				formato.setId(0L);	
					
				formato.setid_empresa(-1L);	
				formato.setid_modulo(-1L);	
				formato.setnombre("");	
				formato.setid_tipo_movimiento(-1L);	
				formato.setid_tipo_formato(-1L);	
				formato.setubicacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormato(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoConstantesFunciones.LABEL_IDTIPOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormatoConstantesFunciones.LABEL_UBICACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormato(String sTipo,Row row,Workbook workbook,Formato formato,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formato.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formato.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formato.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formato.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formato.gettipoformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formato.getubicacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormato=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormato() {
		return this.sFinalQueryFormato;
	}
	
	public void setsFinalQueryFormato(String sFinalQueryFormato) {
		this.sFinalQueryFormato= sFinalQueryFormato;
	}
	
	public Border resaltarSeleccionarFormato=null;
	
	public Border setResaltarSeleccionarFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormato= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormato() {
		return this.resaltarSeleccionarFormato;
	}
	
	public void setResaltarSeleccionarFormato(Border borderResaltarSeleccionarFormato) {
		this.resaltarSeleccionarFormato= borderResaltarSeleccionarFormato;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormato=null;
	public Boolean mostraridFormato=true;
	public Boolean activaridFormato=true;

	public Border resaltarid_empresaFormato=null;
	public Boolean mostrarid_empresaFormato=true;
	public Boolean activarid_empresaFormato=true;
	public Boolean cargarid_empresaFormato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormato=false;//ConEventDepend=true

	public Border resaltarid_moduloFormato=null;
	public Boolean mostrarid_moduloFormato=true;
	public Boolean activarid_moduloFormato=true;
	public Boolean cargarid_moduloFormato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloFormato=false;//ConEventDepend=true

	public Border resaltarnombreFormato=null;
	public Boolean mostrarnombreFormato=true;
	public Boolean activarnombreFormato=true;

	public Border resaltarid_tipo_movimientoFormato=null;
	public Boolean mostrarid_tipo_movimientoFormato=true;
	public Boolean activarid_tipo_movimientoFormato=true;
	public Boolean cargarid_tipo_movimientoFormato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoFormato=false;//ConEventDepend=true

	public Border resaltarid_tipo_formatoFormato=null;
	public Boolean mostrarid_tipo_formatoFormato=true;
	public Boolean activarid_tipo_formatoFormato=true;
	public Boolean cargarid_tipo_formatoFormato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_formatoFormato=false;//ConEventDepend=true

	public Border resaltarubicacionFormato=null;
	public Boolean mostrarubicacionFormato=true;
	public Boolean activarubicacionFormato=true;

	
	

	public Border setResaltaridFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltaridFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormato() {
		return this.resaltaridFormato;
	}

	public void setResaltaridFormato(Border borderResaltar) {
		this.resaltaridFormato= borderResaltar;
	}

	public Boolean getMostraridFormato() {
		return this.mostraridFormato;
	}

	public void setMostraridFormato(Boolean mostraridFormato) {
		this.mostraridFormato= mostraridFormato;
	}

	public Boolean getActivaridFormato() {
		return this.activaridFormato;
	}

	public void setActivaridFormato(Boolean activaridFormato) {
		this.activaridFormato= activaridFormato;
	}

	public Border setResaltarid_empresaFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormato() {
		return this.resaltarid_empresaFormato;
	}

	public void setResaltarid_empresaFormato(Border borderResaltar) {
		this.resaltarid_empresaFormato= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormato() {
		return this.mostrarid_empresaFormato;
	}

	public void setMostrarid_empresaFormato(Boolean mostrarid_empresaFormato) {
		this.mostrarid_empresaFormato= mostrarid_empresaFormato;
	}

	public Boolean getActivarid_empresaFormato() {
		return this.activarid_empresaFormato;
	}

	public void setActivarid_empresaFormato(Boolean activarid_empresaFormato) {
		this.activarid_empresaFormato= activarid_empresaFormato;
	}

	public Boolean getCargarid_empresaFormato() {
		return this.cargarid_empresaFormato;
	}

	public void setCargarid_empresaFormato(Boolean cargarid_empresaFormato) {
		this.cargarid_empresaFormato= cargarid_empresaFormato;
	}

	public Border setResaltarid_moduloFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarid_moduloFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloFormato() {
		return this.resaltarid_moduloFormato;
	}

	public void setResaltarid_moduloFormato(Border borderResaltar) {
		this.resaltarid_moduloFormato= borderResaltar;
	}

	public Boolean getMostrarid_moduloFormato() {
		return this.mostrarid_moduloFormato;
	}

	public void setMostrarid_moduloFormato(Boolean mostrarid_moduloFormato) {
		this.mostrarid_moduloFormato= mostrarid_moduloFormato;
	}

	public Boolean getActivarid_moduloFormato() {
		return this.activarid_moduloFormato;
	}

	public void setActivarid_moduloFormato(Boolean activarid_moduloFormato) {
		this.activarid_moduloFormato= activarid_moduloFormato;
	}

	public Boolean getCargarid_moduloFormato() {
		return this.cargarid_moduloFormato;
	}

	public void setCargarid_moduloFormato(Boolean cargarid_moduloFormato) {
		this.cargarid_moduloFormato= cargarid_moduloFormato;
	}

	public Border setResaltarnombreFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarnombreFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFormato() {
		return this.resaltarnombreFormato;
	}

	public void setResaltarnombreFormato(Border borderResaltar) {
		this.resaltarnombreFormato= borderResaltar;
	}

	public Boolean getMostrarnombreFormato() {
		return this.mostrarnombreFormato;
	}

	public void setMostrarnombreFormato(Boolean mostrarnombreFormato) {
		this.mostrarnombreFormato= mostrarnombreFormato;
	}

	public Boolean getActivarnombreFormato() {
		return this.activarnombreFormato;
	}

	public void setActivarnombreFormato(Boolean activarnombreFormato) {
		this.activarnombreFormato= activarnombreFormato;
	}

	public Border setResaltarid_tipo_movimientoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoFormato() {
		return this.resaltarid_tipo_movimientoFormato;
	}

	public void setResaltarid_tipo_movimientoFormato(Border borderResaltar) {
		this.resaltarid_tipo_movimientoFormato= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoFormato() {
		return this.mostrarid_tipo_movimientoFormato;
	}

	public void setMostrarid_tipo_movimientoFormato(Boolean mostrarid_tipo_movimientoFormato) {
		this.mostrarid_tipo_movimientoFormato= mostrarid_tipo_movimientoFormato;
	}

	public Boolean getActivarid_tipo_movimientoFormato() {
		return this.activarid_tipo_movimientoFormato;
	}

	public void setActivarid_tipo_movimientoFormato(Boolean activarid_tipo_movimientoFormato) {
		this.activarid_tipo_movimientoFormato= activarid_tipo_movimientoFormato;
	}

	public Boolean getCargarid_tipo_movimientoFormato() {
		return this.cargarid_tipo_movimientoFormato;
	}

	public void setCargarid_tipo_movimientoFormato(Boolean cargarid_tipo_movimientoFormato) {
		this.cargarid_tipo_movimientoFormato= cargarid_tipo_movimientoFormato;
	}

	public Border setResaltarid_tipo_formatoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarid_tipo_formatoFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_formatoFormato() {
		return this.resaltarid_tipo_formatoFormato;
	}

	public void setResaltarid_tipo_formatoFormato(Border borderResaltar) {
		this.resaltarid_tipo_formatoFormato= borderResaltar;
	}

	public Boolean getMostrarid_tipo_formatoFormato() {
		return this.mostrarid_tipo_formatoFormato;
	}

	public void setMostrarid_tipo_formatoFormato(Boolean mostrarid_tipo_formatoFormato) {
		this.mostrarid_tipo_formatoFormato= mostrarid_tipo_formatoFormato;
	}

	public Boolean getActivarid_tipo_formatoFormato() {
		return this.activarid_tipo_formatoFormato;
	}

	public void setActivarid_tipo_formatoFormato(Boolean activarid_tipo_formatoFormato) {
		this.activarid_tipo_formatoFormato= activarid_tipo_formatoFormato;
	}

	public Boolean getCargarid_tipo_formatoFormato() {
		return this.cargarid_tipo_formatoFormato;
	}

	public void setCargarid_tipo_formatoFormato(Boolean cargarid_tipo_formatoFormato) {
		this.cargarid_tipo_formatoFormato= cargarid_tipo_formatoFormato;
	}

	public Border setResaltarubicacionFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formatoBeanSwingJInternalFrame.jTtoolBarFormato.setBorder(borderResaltar);
		
		this.resaltarubicacionFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarubicacionFormato() {
		return this.resaltarubicacionFormato;
	}

	public void setResaltarubicacionFormato(Border borderResaltar) {
		this.resaltarubicacionFormato= borderResaltar;
	}

	public Boolean getMostrarubicacionFormato() {
		return this.mostrarubicacionFormato;
	}

	public void setMostrarubicacionFormato(Boolean mostrarubicacionFormato) {
		this.mostrarubicacionFormato= mostrarubicacionFormato;
	}

	public Boolean getActivarubicacionFormato() {
		return this.activarubicacionFormato;
	}

	public void setActivarubicacionFormato(Boolean activarubicacionFormato) {
		this.activarubicacionFormato= activarubicacionFormato;
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
		
		
		this.setMostraridFormato(esInicial);
		this.setMostrarid_empresaFormato(esInicial);
		this.setMostrarid_moduloFormato(esInicial);
		this.setMostrarnombreFormato(esInicial);
		this.setMostrarid_tipo_movimientoFormato(esInicial);
		this.setMostrarid_tipo_formatoFormato(esInicial);
		this.setMostrarubicacionFormato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoConstantesFunciones.ID)) {
				this.setMostraridFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDTIPOFORMATO)) {
				this.setMostrarid_tipo_formatoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.UBICACION)) {
				this.setMostrarubicacionFormato(esAsigna);
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
		
		
		this.setActivaridFormato(esInicial);
		this.setActivarid_empresaFormato(esInicial);
		this.setActivarid_moduloFormato(esInicial);
		this.setActivarnombreFormato(esInicial);
		this.setActivarid_tipo_movimientoFormato(esInicial);
		this.setActivarid_tipo_formatoFormato(esInicial);
		this.setActivarubicacionFormato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoConstantesFunciones.ID)) {
				this.setActivaridFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDTIPOFORMATO)) {
				this.setActivarid_tipo_formatoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.UBICACION)) {
				this.setActivarubicacionFormato(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormato(esInicial);
		this.setResaltarid_empresaFormato(esInicial);
		this.setResaltarid_moduloFormato(esInicial);
		this.setResaltarnombreFormato(esInicial);
		this.setResaltarid_tipo_movimientoFormato(esInicial);
		this.setResaltarid_tipo_formatoFormato(esInicial);
		this.setResaltarubicacionFormato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormatoConstantesFunciones.ID)) {
				this.setResaltaridFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.IDTIPOFORMATO)) {
				this.setResaltarid_tipo_formatoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormatoConstantesFunciones.UBICACION)) {
				this.setResaltarubicacionFormato(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreFormato=true;

	public Boolean getMostrarBusquedaPorNombreFormato() {
		return this.mostrarBusquedaPorNombreFormato;
	}

	public void setMostrarBusquedaPorNombreFormato(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreFormato= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormato=true;

	public Boolean getMostrarFK_IdEmpresaFormato() {
		return this.mostrarFK_IdEmpresaFormato;
	}

	public void setMostrarFK_IdEmpresaFormato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormato= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloFormato=true;

	public Boolean getMostrarFK_IdModuloFormato() {
		return this.mostrarFK_IdModuloFormato;
	}

	public void setMostrarFK_IdModuloFormato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloFormato= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormatoFormato=true;

	public Boolean getMostrarFK_IdTipoFormatoFormato() {
		return this.mostrarFK_IdTipoFormatoFormato;
	}

	public void setMostrarFK_IdTipoFormatoFormato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormatoFormato= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoFormato=true;

	public Boolean getMostrarFK_IdTipoMovimientoFormato() {
		return this.mostrarFK_IdTipoMovimientoFormato;
	}

	public void setMostrarFK_IdTipoMovimientoFormato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoFormato= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreFormato=true;

	public Boolean getActivarBusquedaPorNombreFormato() {
		return this.activarBusquedaPorNombreFormato;
	}

	public void setActivarBusquedaPorNombreFormato(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreFormato= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormato=true;

	public Boolean getActivarFK_IdEmpresaFormato() {
		return this.activarFK_IdEmpresaFormato;
	}

	public void setActivarFK_IdEmpresaFormato(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormato= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloFormato=true;

	public Boolean getActivarFK_IdModuloFormato() {
		return this.activarFK_IdModuloFormato;
	}

	public void setActivarFK_IdModuloFormato(Boolean habilitarResaltar) {
		this.activarFK_IdModuloFormato= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormatoFormato=true;

	public Boolean getActivarFK_IdTipoFormatoFormato() {
		return this.activarFK_IdTipoFormatoFormato;
	}

	public void setActivarFK_IdTipoFormatoFormato(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormatoFormato= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoFormato=true;

	public Boolean getActivarFK_IdTipoMovimientoFormato() {
		return this.activarFK_IdTipoMovimientoFormato;
	}

	public void setActivarFK_IdTipoMovimientoFormato(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoFormato= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreFormato=null;

	public Border getResaltarBusquedaPorNombreFormato() {
		return this.resaltarBusquedaPorNombreFormato;
	}

	public void setResaltarBusquedaPorNombreFormato(Border borderResaltar) {
		this.resaltarBusquedaPorNombreFormato= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreFormato= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormato=null;

	public Border getResaltarFK_IdEmpresaFormato() {
		return this.resaltarFK_IdEmpresaFormato;
	}

	public void setResaltarFK_IdEmpresaFormato(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormato= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormato= borderResaltar;
	}

	public Border resaltarFK_IdModuloFormato=null;

	public Border getResaltarFK_IdModuloFormato() {
		return this.resaltarFK_IdModuloFormato;
	}

	public void setResaltarFK_IdModuloFormato(Border borderResaltar) {
		this.resaltarFK_IdModuloFormato= borderResaltar;
	}

	public void setResaltarFK_IdModuloFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloFormato= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormatoFormato=null;

	public Border getResaltarFK_IdTipoFormatoFormato() {
		return this.resaltarFK_IdTipoFormatoFormato;
	}

	public void setResaltarFK_IdTipoFormatoFormato(Border borderResaltar) {
		this.resaltarFK_IdTipoFormatoFormato= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormatoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormatoFormato= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoFormato=null;

	public Border getResaltarFK_IdTipoMovimientoFormato() {
		return this.resaltarFK_IdTipoMovimientoFormato;
	}

	public void setResaltarFK_IdTipoMovimientoFormato(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoFormato= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*FormatoBeanSwingJInternalFrame formatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoFormato= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}