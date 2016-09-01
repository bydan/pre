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


import com.bydan.erp.contabilidad.util.TipoDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoDocumentoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoDocumentoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDocumentoConstantesFunciones extends TipoDocumentoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDocumento";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDocumento"+TipoDocumentoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDocumentoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDocumentoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDocumentoConstantesFunciones.SCHEMA+"_"+TipoDocumentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDocumentoConstantesFunciones.SCHEMA+"_"+TipoDocumentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDocumentoConstantesFunciones.SCHEMA+"_"+TipoDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDocumentoConstantesFunciones.SCHEMA+"_"+TipoDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDocumentoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDocumentoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDocumentoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDocumentoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Documentos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Documento";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Documento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDocumento";
	public static final String OBJECTNAME="tipodocumento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_documento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodocumento from "+TipoDocumentoConstantesFunciones.SPERSISTENCENAME+" tipodocumento";
	public static String QUERYSELECTNATIVE="select "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_modulo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".nombre,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".es_defecto,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".es_mayor from "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDocumentoConstantesFuncionesAdditional tipodocumentoConstantesFuncionesAdditional=null;
	
	public TipoDocumentoConstantesFuncionesAdditional getTipoDocumentoConstantesFuncionesAdditional() {
		return this.tipodocumentoConstantesFuncionesAdditional;
	}
	
	public void setTipoDocumentoConstantesFuncionesAdditional(TipoDocumentoConstantesFuncionesAdditional tipodocumentoConstantesFuncionesAdditional) {
		try {
			this.tipodocumentoConstantesFuncionesAdditional=tipodocumentoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOMOVIMIENTOMODULO= "id_tipo_movimiento_modulo";
    public static final String ESDEFECTO= "es_defecto";
    public static final String ESMAYOR= "es_mayor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Tipo Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "es Defecto";
    	public static final String LABEL_ESMAYOR= "Es Mayor";
		public static final String LABEL_ESMAYOR_LOWER= "es Mayor";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getTipoDocumentoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.IDMODULO)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.CODIGO)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.ESDEFECTO)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_ESDEFECTO;}
		if(sNombreColumna.equals(TipoDocumentoConstantesFunciones.ESMAYOR)) {sLabelColumna=TipoDocumentoConstantesFunciones.LABEL_ESMAYOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getes_defectoDescripcion(TipoDocumento tipodocumento) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipodocumento.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(TipoDocumento tipodocumento) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipodocumento.getId(),tipodocumento.getes_defecto());

		return sDescripcion;
	}	
		
	public static String getes_mayorDescripcion(TipoDocumento tipodocumento) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipodocumento.getes_mayor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_mayorHtmlDescripcion(TipoDocumento tipodocumento) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipodocumento.getId(),tipodocumento.getes_mayor());

		return sDescripcion;
	}	
	
	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodocumento !=null/* && tipodocumento.getId()!=0*/) {
			sDescripcion=tipodocumento.getcodigo()+"-"+tipodocumento.getnombre();//tipodocumentotipodocumento.getcodigo().trim()+"-"+tipodocumento.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDocumentoDescripcionDetallado(TipoDocumento tipodocumento) {
		String sDescripcion="";
			
		sDescripcion+=TipoDocumentoConstantesFunciones.ID+"=";
		sDescripcion+=tipodocumento.getId().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodocumento.getVersionRow().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodocumento.getid_empresa().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=tipodocumento.getid_modulo().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=tipodocumento.getid_tipo_movimiento().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodocumento.getcodigo()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodocumento.getnombre()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=tipodocumento.getid_tipo_movimiento_modulo().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=tipodocumento.getes_defecto().toString()+",";
		sDescripcion+=TipoDocumentoConstantesFunciones.ESMAYOR+"=";
		sDescripcion+=tipodocumento.getes_mayor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDocumentoDescripcion(TipoDocumento tipodocumento,String sValor) throws Exception {			
		if(tipodocumento !=null) {
			tipodocumento.setcodigo(sValor);
tipodocumento.setnombre(sValor);;//tipodocumentotipodocumento.getcodigo().trim()+"-"+tipodocumento.getnombre().trim();
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

	public static String getTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimientomodulo!=null/*&&tipomovimientomodulo.getId()>0*/) {
			sDescripcion=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipomovimientomodulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorIdModuloPorIdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Modulo Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("PorEmpresaPorModuloPorTipoMoviModu")) {
			sNombreIndice="Tipo=  Por Empresa Por Modulo Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("PorIdPorEmprePorModuPorTiMovPorTiMovModu")) {
			sNombreIndice="Tipo=  Por Id Por Empresa Por Modulo Por Tipo Movimiento Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("PorIdPorEmpresaPorModuPorTiMoviModu")) {
			sNombreIndice="Tipo=  Por Id Por Empresa Por Modulo Por Tipo Movimiento Modulo";
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

	public static String getDetalleIndiceBusquedaPorIdModuloPorIdTipoMovimientoModulo(Long id_modulo,Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimientoModulo(Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorModuloPorTipoMoviModu(Long id_empresa,Long id_modulo,Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorEmprePorModuPorTiMovPorTiMovModu(Long id,Long id_empresa,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();}
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorEmpresaPorModuPorTiMoviModu(Long id,Long id_empresa,Long id_modulo,Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDocumento(TipoDocumento tipodocumento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodocumento.setcodigo(tipodocumento.getcodigo().trim());
		tipodocumento.setnombre(tipodocumento.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDocumentos(List<TipoDocumento> tipodocumentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDocumento tipodocumento: tipodocumentos) {
			tipodocumento.setcodigo(tipodocumento.getcodigo().trim());
			tipodocumento.setnombre(tipodocumento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDocumento(TipoDocumento tipodocumento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodocumento.getConCambioAuxiliar()) {
			tipodocumento.setIsDeleted(tipodocumento.getIsDeletedAuxiliar());	
			tipodocumento.setIsNew(tipodocumento.getIsNewAuxiliar());	
			tipodocumento.setIsChanged(tipodocumento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodocumento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodocumento.setIsDeletedAuxiliar(false);	
			tipodocumento.setIsNewAuxiliar(false);	
			tipodocumento.setIsChangedAuxiliar(false);
			
			tipodocumento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDocumentos(List<TipoDocumento> tipodocumentos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDocumento tipodocumento : tipodocumentos) {
			if(conAsignarBase && tipodocumento.getConCambioAuxiliar()) {
				tipodocumento.setIsDeleted(tipodocumento.getIsDeletedAuxiliar());	
				tipodocumento.setIsNew(tipodocumento.getIsNewAuxiliar());	
				tipodocumento.setIsChanged(tipodocumento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodocumento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodocumento.setIsDeletedAuxiliar(false);	
				tipodocumento.setIsNewAuxiliar(false);	
				tipodocumento.setIsChangedAuxiliar(false);
				
				tipodocumento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDocumento(TipoDocumento tipodocumento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDocumentos(List<TipoDocumento> tipodocumentos,Boolean conEnteros) throws Exception  {
		
		for(TipoDocumento tipodocumento: tipodocumentos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDocumento(List<TipoDocumento> tipodocumentos,TipoDocumento tipodocumentoAux) throws Exception  {
		TipoDocumentoConstantesFunciones.InicializarValoresTipoDocumento(tipodocumentoAux,true);
		
		for(TipoDocumento tipodocumento: tipodocumentos) {
			if(tipodocumento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDocumento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDocumentoConstantesFunciones.getArrayColumnasGlobalesTipoDocumento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDocumento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDocumentoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDocumentoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDocumentoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDocumentoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDocumento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoDocumentoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDocumento> tipodocumentos,TipoDocumento tipodocumento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDocumento tipodocumentoAux: tipodocumentos) {
			if(tipodocumentoAux!=null && tipodocumento!=null) {
				if((tipodocumentoAux.getId()==null && tipodocumento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodocumentoAux.getId()!=null && tipodocumento.getId()!=null){
					if(tipodocumentoAux.getId().equals(tipodocumento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDocumento(List<TipoDocumento> tipodocumentos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDocumento tipodocumento: tipodocumentos) {			
			if(tipodocumento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDocumento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_ID, TipoDocumentoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_VERSIONROW, TipoDocumentoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_IDEMPRESA, TipoDocumentoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_IDMODULO, TipoDocumentoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_CODIGO, TipoDocumentoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_NOMBRE, TipoDocumentoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_ESDEFECTO, TipoDocumentoConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoConstantesFunciones.LABEL_ESMAYOR, TipoDocumentoConstantesFunciones.ESMAYOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDocumento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoConstantesFunciones.ESMAYOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumento() throws Exception  {
		return TipoDocumentoConstantesFunciones.getTiposSeleccionarTipoDocumento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumento(Boolean conFk) throws Exception  {
		return TipoDocumentoConstantesFunciones.getTiposSeleccionarTipoDocumento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoConstantesFunciones.LABEL_ESMAYOR);
			reporte.setsDescripcion(TipoDocumentoConstantesFunciones.LABEL_ESMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDocumento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDocumento(TipoDocumento tipodocumentoAux) throws Exception {
		
			tipodocumentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodocumentoAux.getEmpresa()));
			tipodocumentoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipodocumentoAux.getModulo()));
			tipodocumentoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipodocumentoAux.getTipoMovimiento()));
			tipodocumentoAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipodocumentoAux.getTipoMovimientoModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDocumento(List<TipoDocumento> tipodocumentosTemp) throws Exception {
		for(TipoDocumento tipodocumentoAux:tipodocumentosTemp) {
			
			tipodocumentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodocumentoAux.getEmpresa()));
			tipodocumentoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipodocumentoAux.getModulo()));
			tipodocumentoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipodocumentoAux.getTipoMovimiento()));
			tipodocumentoAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipodocumentoAux.getTipoMovimientoModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoMovimientoModulo.class));
				
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
					if(clas.clas.equals(TipoMovimientoModulo.class)) {
						classes.add(new Classe(TipoMovimientoModulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
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

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDocumentoConstantesFunciones.getClassesRelationshipsOfTipoDocumento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDocumentoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDocumento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoDocumento tipodocumento,List<TipoDocumento> tipodocumentos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDocumento tipodocumentoEncontrado=null;
			
			for(TipoDocumento tipodocumentoLocal:tipodocumentos) {
				if(tipodocumentoLocal.getId().equals(tipodocumento.getId())) {
					tipodocumentoEncontrado=tipodocumentoLocal;
					
					tipodocumentoLocal.setIsChanged(tipodocumento.getIsChanged());
					tipodocumentoLocal.setIsNew(tipodocumento.getIsNew());
					tipodocumentoLocal.setIsDeleted(tipodocumento.getIsDeleted());
					
					tipodocumentoLocal.setGeneralEntityOriginal(tipodocumento.getGeneralEntityOriginal());
					
					tipodocumentoLocal.setId(tipodocumento.getId());	
					tipodocumentoLocal.setVersionRow(tipodocumento.getVersionRow());	
					tipodocumentoLocal.setid_empresa(tipodocumento.getid_empresa());	
					tipodocumentoLocal.setid_modulo(tipodocumento.getid_modulo());	
					tipodocumentoLocal.setid_tipo_movimiento(tipodocumento.getid_tipo_movimiento());	
					tipodocumentoLocal.setcodigo(tipodocumento.getcodigo());	
					tipodocumentoLocal.setnombre(tipodocumento.getnombre());	
					tipodocumentoLocal.setid_tipo_movimiento_modulo(tipodocumento.getid_tipo_movimiento_modulo());	
					tipodocumentoLocal.setes_defecto(tipodocumento.getes_defecto());	
					tipodocumentoLocal.setes_mayor(tipodocumento.getes_mayor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodocumento.getIsDeleted()) {
				if(!existe) {
					tipodocumentos.add(tipodocumento);
				}
			} else {
				if(tipodocumentoEncontrado!=null && permiteQuitar)  {
					tipodocumentos.remove(tipodocumentoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDocumento tipodocumento,List<TipoDocumento> tipodocumentos) throws Exception {
		try	{			
			for(TipoDocumento tipodocumentoLocal:tipodocumentos) {
				if(tipodocumentoLocal.getId().equals(tipodocumento.getId())) {
					tipodocumentoLocal.setIsSelected(tipodocumento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDocumento(List<TipoDocumento> tipodocumentosAux) throws Exception {
		//this.tipodocumentosAux=tipodocumentosAux;
		
		for(TipoDocumento tipodocumentoAux:tipodocumentosAux) {
			if(tipodocumentoAux.getIsChanged()) {
				tipodocumentoAux.setIsChanged(false);
			}		
			
			if(tipodocumentoAux.getIsNew()) {
				tipodocumentoAux.setIsNew(false);
			}	
			
			if(tipodocumentoAux.getIsDeleted()) {
				tipodocumentoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDocumento(TipoDocumento tipodocumentoAux) throws Exception {
		//this.tipodocumentoAux=tipodocumentoAux;
		
			if(tipodocumentoAux.getIsChanged()) {
				tipodocumentoAux.setIsChanged(false);
			}		
			
			if(tipodocumentoAux.getIsNew()) {
				tipodocumentoAux.setIsNew(false);
			}	
			
			if(tipodocumentoAux.getIsDeleted()) {
				tipodocumentoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDocumento tipodocumentoAsignar,TipoDocumento tipodocumento) throws Exception {
		tipodocumentoAsignar.setId(tipodocumento.getId());	
		tipodocumentoAsignar.setVersionRow(tipodocumento.getVersionRow());	
		tipodocumentoAsignar.setid_empresa(tipodocumento.getid_empresa());
		tipodocumentoAsignar.setempresa_descripcion(tipodocumento.getempresa_descripcion());	
		tipodocumentoAsignar.setid_modulo(tipodocumento.getid_modulo());
		tipodocumentoAsignar.setmodulo_descripcion(tipodocumento.getmodulo_descripcion());	
		tipodocumentoAsignar.setid_tipo_movimiento(tipodocumento.getid_tipo_movimiento());
		tipodocumentoAsignar.settipomovimiento_descripcion(tipodocumento.gettipomovimiento_descripcion());	
		tipodocumentoAsignar.setcodigo(tipodocumento.getcodigo());	
		tipodocumentoAsignar.setnombre(tipodocumento.getnombre());	
		tipodocumentoAsignar.setid_tipo_movimiento_modulo(tipodocumento.getid_tipo_movimiento_modulo());
		tipodocumentoAsignar.settipomovimientomodulo_descripcion(tipodocumento.gettipomovimientomodulo_descripcion());	
		tipodocumentoAsignar.setes_defecto(tipodocumento.getes_defecto());	
		tipodocumentoAsignar.setes_mayor(tipodocumento.getes_mayor());	
	}
	
	public static void inicializarTipoDocumento(TipoDocumento tipodocumento) throws Exception {
		try {
				tipodocumento.setId(0L);	
					
				tipodocumento.setid_empresa(-1L);	
				tipodocumento.setid_modulo(-1L);	
				tipodocumento.setid_tipo_movimiento(-1L);	
				tipodocumento.setcodigo("");	
				tipodocumento.setnombre("");	
				tipodocumento.setid_tipo_movimiento_modulo(-1L);	
				tipodocumento.setes_defecto(false);	
				tipodocumento.setes_mayor(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDocumento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoConstantesFunciones.LABEL_ESMAYOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDocumento(String sTipo,Row row,Workbook workbook,TipoDocumento tipodocumento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumento.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumento.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumento.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumento.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumento.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipodocumento.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipodocumento.getes_mayor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDocumento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDocumento() {
		return this.sFinalQueryTipoDocumento;
	}
	
	public void setsFinalQueryTipoDocumento(String sFinalQueryTipoDocumento) {
		this.sFinalQueryTipoDocumento= sFinalQueryTipoDocumento;
	}
	
	public Border resaltarSeleccionarTipoDocumento=null;
	
	public Border setResaltarSeleccionarTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDocumento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDocumento() {
		return this.resaltarSeleccionarTipoDocumento;
	}
	
	public void setResaltarSeleccionarTipoDocumento(Border borderResaltarSeleccionarTipoDocumento) {
		this.resaltarSeleccionarTipoDocumento= borderResaltarSeleccionarTipoDocumento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDocumento=null;
	public Boolean mostraridTipoDocumento=true;
	public Boolean activaridTipoDocumento=true;

	public Border resaltarid_empresaTipoDocumento=null;
	public Boolean mostrarid_empresaTipoDocumento=true;
	public Boolean activarid_empresaTipoDocumento=true;
	public Boolean cargarid_empresaTipoDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDocumento=false;//ConEventDepend=true

	public Border resaltarid_moduloTipoDocumento=null;
	public Boolean mostrarid_moduloTipoDocumento=true;
	public Boolean activarid_moduloTipoDocumento=true;
	public Boolean cargarid_moduloTipoDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTipoDocumento=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoTipoDocumento=null;
	public Boolean mostrarid_tipo_movimientoTipoDocumento=true;
	public Boolean activarid_tipo_movimientoTipoDocumento=true;
	public Boolean cargarid_tipo_movimientoTipoDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoTipoDocumento=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDocumento=null;
	public Boolean mostrarcodigoTipoDocumento=true;
	public Boolean activarcodigoTipoDocumento=true;

	public Border resaltarnombreTipoDocumento=null;
	public Boolean mostrarnombreTipoDocumento=true;
	public Boolean activarnombreTipoDocumento=true;

	public Border resaltarid_tipo_movimiento_moduloTipoDocumento=null;
	public Boolean mostrarid_tipo_movimiento_moduloTipoDocumento=true;
	public Boolean activarid_tipo_movimiento_moduloTipoDocumento=false;
	public Boolean cargarid_tipo_movimiento_moduloTipoDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloTipoDocumento=true;//ConEventDepend=true

	public Border resaltares_defectoTipoDocumento=null;
	public Boolean mostrares_defectoTipoDocumento=true;
	public Boolean activares_defectoTipoDocumento=true;

	public Border resaltares_mayorTipoDocumento=null;
	public Boolean mostrares_mayorTipoDocumento=true;
	public Boolean activares_mayorTipoDocumento=true;

	
	

	public Border setResaltaridTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltaridTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDocumento() {
		return this.resaltaridTipoDocumento;
	}

	public void setResaltaridTipoDocumento(Border borderResaltar) {
		this.resaltaridTipoDocumento= borderResaltar;
	}

	public Boolean getMostraridTipoDocumento() {
		return this.mostraridTipoDocumento;
	}

	public void setMostraridTipoDocumento(Boolean mostraridTipoDocumento) {
		this.mostraridTipoDocumento= mostraridTipoDocumento;
	}

	public Boolean getActivaridTipoDocumento() {
		return this.activaridTipoDocumento;
	}

	public void setActivaridTipoDocumento(Boolean activaridTipoDocumento) {
		this.activaridTipoDocumento= activaridTipoDocumento;
	}

	public Border setResaltarid_empresaTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDocumento() {
		return this.resaltarid_empresaTipoDocumento;
	}

	public void setResaltarid_empresaTipoDocumento(Border borderResaltar) {
		this.resaltarid_empresaTipoDocumento= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDocumento() {
		return this.mostrarid_empresaTipoDocumento;
	}

	public void setMostrarid_empresaTipoDocumento(Boolean mostrarid_empresaTipoDocumento) {
		this.mostrarid_empresaTipoDocumento= mostrarid_empresaTipoDocumento;
	}

	public Boolean getActivarid_empresaTipoDocumento() {
		return this.activarid_empresaTipoDocumento;
	}

	public void setActivarid_empresaTipoDocumento(Boolean activarid_empresaTipoDocumento) {
		this.activarid_empresaTipoDocumento= activarid_empresaTipoDocumento;
	}

	public Boolean getCargarid_empresaTipoDocumento() {
		return this.cargarid_empresaTipoDocumento;
	}

	public void setCargarid_empresaTipoDocumento(Boolean cargarid_empresaTipoDocumento) {
		this.cargarid_empresaTipoDocumento= cargarid_empresaTipoDocumento;
	}

	public Border setResaltarid_moduloTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarid_moduloTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTipoDocumento() {
		return this.resaltarid_moduloTipoDocumento;
	}

	public void setResaltarid_moduloTipoDocumento(Border borderResaltar) {
		this.resaltarid_moduloTipoDocumento= borderResaltar;
	}

	public Boolean getMostrarid_moduloTipoDocumento() {
		return this.mostrarid_moduloTipoDocumento;
	}

	public void setMostrarid_moduloTipoDocumento(Boolean mostrarid_moduloTipoDocumento) {
		this.mostrarid_moduloTipoDocumento= mostrarid_moduloTipoDocumento;
	}

	public Boolean getActivarid_moduloTipoDocumento() {
		return this.activarid_moduloTipoDocumento;
	}

	public void setActivarid_moduloTipoDocumento(Boolean activarid_moduloTipoDocumento) {
		this.activarid_moduloTipoDocumento= activarid_moduloTipoDocumento;
	}

	public Boolean getCargarid_moduloTipoDocumento() {
		return this.cargarid_moduloTipoDocumento;
	}

	public void setCargarid_moduloTipoDocumento(Boolean cargarid_moduloTipoDocumento) {
		this.cargarid_moduloTipoDocumento= cargarid_moduloTipoDocumento;
	}

	public Border setResaltarid_tipo_movimientoTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoTipoDocumento() {
		return this.resaltarid_tipo_movimientoTipoDocumento;
	}

	public void setResaltarid_tipo_movimientoTipoDocumento(Border borderResaltar) {
		this.resaltarid_tipo_movimientoTipoDocumento= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoTipoDocumento() {
		return this.mostrarid_tipo_movimientoTipoDocumento;
	}

	public void setMostrarid_tipo_movimientoTipoDocumento(Boolean mostrarid_tipo_movimientoTipoDocumento) {
		this.mostrarid_tipo_movimientoTipoDocumento= mostrarid_tipo_movimientoTipoDocumento;
	}

	public Boolean getActivarid_tipo_movimientoTipoDocumento() {
		return this.activarid_tipo_movimientoTipoDocumento;
	}

	public void setActivarid_tipo_movimientoTipoDocumento(Boolean activarid_tipo_movimientoTipoDocumento) {
		this.activarid_tipo_movimientoTipoDocumento= activarid_tipo_movimientoTipoDocumento;
	}

	public Boolean getCargarid_tipo_movimientoTipoDocumento() {
		return this.cargarid_tipo_movimientoTipoDocumento;
	}

	public void setCargarid_tipo_movimientoTipoDocumento(Boolean cargarid_tipo_movimientoTipoDocumento) {
		this.cargarid_tipo_movimientoTipoDocumento= cargarid_tipo_movimientoTipoDocumento;
	}

	public Border setResaltarcodigoTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDocumento() {
		return this.resaltarcodigoTipoDocumento;
	}

	public void setResaltarcodigoTipoDocumento(Border borderResaltar) {
		this.resaltarcodigoTipoDocumento= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDocumento() {
		return this.mostrarcodigoTipoDocumento;
	}

	public void setMostrarcodigoTipoDocumento(Boolean mostrarcodigoTipoDocumento) {
		this.mostrarcodigoTipoDocumento= mostrarcodigoTipoDocumento;
	}

	public Boolean getActivarcodigoTipoDocumento() {
		return this.activarcodigoTipoDocumento;
	}

	public void setActivarcodigoTipoDocumento(Boolean activarcodigoTipoDocumento) {
		this.activarcodigoTipoDocumento= activarcodigoTipoDocumento;
	}

	public Border setResaltarnombreTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDocumento() {
		return this.resaltarnombreTipoDocumento;
	}

	public void setResaltarnombreTipoDocumento(Border borderResaltar) {
		this.resaltarnombreTipoDocumento= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDocumento() {
		return this.mostrarnombreTipoDocumento;
	}

	public void setMostrarnombreTipoDocumento(Boolean mostrarnombreTipoDocumento) {
		this.mostrarnombreTipoDocumento= mostrarnombreTipoDocumento;
	}

	public Boolean getActivarnombreTipoDocumento() {
		return this.activarnombreTipoDocumento;
	}

	public void setActivarnombreTipoDocumento(Boolean activarnombreTipoDocumento) {
		this.activarnombreTipoDocumento= activarnombreTipoDocumento;
	}

	public Border setResaltarid_tipo_movimiento_moduloTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloTipoDocumento() {
		return this.resaltarid_tipo_movimiento_moduloTipoDocumento;
	}

	public void setResaltarid_tipo_movimiento_moduloTipoDocumento(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloTipoDocumento= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloTipoDocumento() {
		return this.mostrarid_tipo_movimiento_moduloTipoDocumento;
	}

	public void setMostrarid_tipo_movimiento_moduloTipoDocumento(Boolean mostrarid_tipo_movimiento_moduloTipoDocumento) {
		this.mostrarid_tipo_movimiento_moduloTipoDocumento= mostrarid_tipo_movimiento_moduloTipoDocumento;
	}

	public Boolean getActivarid_tipo_movimiento_moduloTipoDocumento() {
		return this.activarid_tipo_movimiento_moduloTipoDocumento;
	}

	public void setActivarid_tipo_movimiento_moduloTipoDocumento(Boolean activarid_tipo_movimiento_moduloTipoDocumento) {
		this.activarid_tipo_movimiento_moduloTipoDocumento= activarid_tipo_movimiento_moduloTipoDocumento;
	}

	public Boolean getCargarid_tipo_movimiento_moduloTipoDocumento() {
		return this.cargarid_tipo_movimiento_moduloTipoDocumento;
	}

	public void setCargarid_tipo_movimiento_moduloTipoDocumento(Boolean cargarid_tipo_movimiento_moduloTipoDocumento) {
		this.cargarid_tipo_movimiento_moduloTipoDocumento= cargarid_tipo_movimiento_moduloTipoDocumento;
	}

	public Border setResaltares_defectoTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltares_defectoTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoTipoDocumento() {
		return this.resaltares_defectoTipoDocumento;
	}

	public void setResaltares_defectoTipoDocumento(Border borderResaltar) {
		this.resaltares_defectoTipoDocumento= borderResaltar;
	}

	public Boolean getMostrares_defectoTipoDocumento() {
		return this.mostrares_defectoTipoDocumento;
	}

	public void setMostrares_defectoTipoDocumento(Boolean mostrares_defectoTipoDocumento) {
		this.mostrares_defectoTipoDocumento= mostrares_defectoTipoDocumento;
	}

	public Boolean getActivares_defectoTipoDocumento() {
		return this.activares_defectoTipoDocumento;
	}

	public void setActivares_defectoTipoDocumento(Boolean activares_defectoTipoDocumento) {
		this.activares_defectoTipoDocumento= activares_defectoTipoDocumento;
	}

	public Border setResaltares_mayorTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentoBeanSwingJInternalFrame.jTtoolBarTipoDocumento.setBorder(borderResaltar);
		
		this.resaltares_mayorTipoDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_mayorTipoDocumento() {
		return this.resaltares_mayorTipoDocumento;
	}

	public void setResaltares_mayorTipoDocumento(Border borderResaltar) {
		this.resaltares_mayorTipoDocumento= borderResaltar;
	}

	public Boolean getMostrares_mayorTipoDocumento() {
		return this.mostrares_mayorTipoDocumento;
	}

	public void setMostrares_mayorTipoDocumento(Boolean mostrares_mayorTipoDocumento) {
		this.mostrares_mayorTipoDocumento= mostrares_mayorTipoDocumento;
	}

	public Boolean getActivares_mayorTipoDocumento() {
		return this.activares_mayorTipoDocumento;
	}

	public void setActivares_mayorTipoDocumento(Boolean activares_mayorTipoDocumento) {
		this.activares_mayorTipoDocumento= activares_mayorTipoDocumento;
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
		
		
		this.setMostraridTipoDocumento(esInicial);
		this.setMostrarid_empresaTipoDocumento(esInicial);
		this.setMostrarid_moduloTipoDocumento(esInicial);
		this.setMostrarid_tipo_movimientoTipoDocumento(esInicial);
		this.setMostrarcodigoTipoDocumento(esInicial);
		this.setMostrarnombreTipoDocumento(esInicial);
		this.setMostrarid_tipo_movimiento_moduloTipoDocumento(esInicial);
		this.setMostrares_defectoTipoDocumento(esInicial);
		this.setMostrares_mayorTipoDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ID)) {
				this.setMostraridTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ESMAYOR)) {
				this.setMostrares_mayorTipoDocumento(esAsigna);
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
		
		
		this.setActivaridTipoDocumento(esInicial);
		this.setActivarid_empresaTipoDocumento(esInicial);
		this.setActivarid_moduloTipoDocumento(esInicial);
		this.setActivarid_tipo_movimientoTipoDocumento(esInicial);
		this.setActivarcodigoTipoDocumento(esInicial);
		this.setActivarnombreTipoDocumento(esInicial);
		this.setActivarid_tipo_movimiento_moduloTipoDocumento(esInicial);
		this.setActivares_defectoTipoDocumento(esInicial);
		this.setActivares_mayorTipoDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ID)) {
				this.setActivaridTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ESMAYOR)) {
				this.setActivares_mayorTipoDocumento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDocumento(esInicial);
		this.setResaltarid_empresaTipoDocumento(esInicial);
		this.setResaltarid_moduloTipoDocumento(esInicial);
		this.setResaltarid_tipo_movimientoTipoDocumento(esInicial);
		this.setResaltarcodigoTipoDocumento(esInicial);
		this.setResaltarnombreTipoDocumento(esInicial);
		this.setResaltarid_tipo_movimiento_moduloTipoDocumento(esInicial);
		this.setResaltares_defectoTipoDocumento(esInicial);
		this.setResaltares_mayorTipoDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ID)) {
				this.setResaltaridTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoTipoDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoConstantesFunciones.ESMAYOR)) {
				this.setResaltares_mayorTipoDocumento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDocumento=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDocumento() {
		return this.mostrarBusquedaPorCodigoTipoDocumento;
	}

	public void setMostrarBusquedaPorCodigoTipoDocumento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDocumento= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento=true;

	public Boolean getMostrarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento() {
		return this.mostrarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento;
	}

	public void setMostrarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDocumento=true;

	public Boolean getMostrarBusquedaPorNombreTipoDocumento() {
		return this.mostrarBusquedaPorNombreTipoDocumento;
	}

	public void setMostrarBusquedaPorNombreTipoDocumento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoDocumento=true;

	public Boolean getMostrarFK_IdEmpresaTipoDocumento() {
		return this.mostrarFK_IdEmpresaTipoDocumento;
	}

	public void setMostrarFK_IdEmpresaTipoDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTipoDocumento=true;

	public Boolean getMostrarFK_IdModuloTipoDocumento() {
		return this.mostrarFK_IdModuloTipoDocumento;
	}

	public void setMostrarFK_IdModuloTipoDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTipoDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoTipoDocumento=true;

	public Boolean getMostrarFK_IdTipoMovimientoTipoDocumento() {
		return this.mostrarFK_IdTipoMovimientoTipoDocumento;
	}

	public void setMostrarFK_IdTipoMovimientoTipoDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoTipoDocumento= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDocumento=true;

	public Boolean getActivarBusquedaPorCodigoTipoDocumento() {
		return this.activarBusquedaPorCodigoTipoDocumento;
	}

	public void setActivarBusquedaPorCodigoTipoDocumento(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDocumento= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento=true;

	public Boolean getActivarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento() {
		return this.activarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento;
	}

	public void setActivarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDocumento=true;

	public Boolean getActivarBusquedaPorNombreTipoDocumento() {
		return this.activarBusquedaPorNombreTipoDocumento;
	}

	public void setActivarBusquedaPorNombreTipoDocumento(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoDocumento=true;

	public Boolean getActivarFK_IdEmpresaTipoDocumento() {
		return this.activarFK_IdEmpresaTipoDocumento;
	}

	public void setActivarFK_IdEmpresaTipoDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTipoDocumento=true;

	public Boolean getActivarFK_IdModuloTipoDocumento() {
		return this.activarFK_IdModuloTipoDocumento;
	}

	public void setActivarFK_IdModuloTipoDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTipoDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoTipoDocumento=true;

	public Boolean getActivarFK_IdTipoMovimientoTipoDocumento() {
		return this.activarFK_IdTipoMovimientoTipoDocumento;
	}

	public void setActivarFK_IdTipoMovimientoTipoDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoTipoDocumento= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDocumento=null;

	public Border getResaltarBusquedaPorCodigoTipoDocumento() {
		return this.resaltarBusquedaPorCodigoTipoDocumento;
	}

	public void setResaltarBusquedaPorCodigoTipoDocumento(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDocumento= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDocumento= borderResaltar;
	}

	public Border resaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento=null;

	public Border getResaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento() {
		return this.resaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento;
	}

	public void setResaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento(Border borderResaltar) {
		this.resaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento= borderResaltar;
	}

	public void setResaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdModuloPorIdTipoMovimientoModuloTipoDocumento= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDocumento=null;

	public Border getResaltarBusquedaPorNombreTipoDocumento() {
		return this.resaltarBusquedaPorNombreTipoDocumento;
	}

	public void setResaltarBusquedaPorNombreTipoDocumento(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDocumento= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDocumento= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoDocumento=null;

	public Border getResaltarFK_IdEmpresaTipoDocumento() {
		return this.resaltarFK_IdEmpresaTipoDocumento;
	}

	public void setResaltarFK_IdEmpresaTipoDocumento(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDocumento= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDocumento= borderResaltar;
	}

	public Border resaltarFK_IdModuloTipoDocumento=null;

	public Border getResaltarFK_IdModuloTipoDocumento() {
		return this.resaltarFK_IdModuloTipoDocumento;
	}

	public void setResaltarFK_IdModuloTipoDocumento(Border borderResaltar) {
		this.resaltarFK_IdModuloTipoDocumento= borderResaltar;
	}

	public void setResaltarFK_IdModuloTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTipoDocumento= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoTipoDocumento=null;

	public Border getResaltarFK_IdTipoMovimientoTipoDocumento() {
		return this.resaltarFK_IdTipoMovimientoTipoDocumento;
	}

	public void setResaltarFK_IdTipoMovimientoTipoDocumento(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoTipoDocumento= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoTipoDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoBeanSwingJInternalFrame tipodocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoTipoDocumento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}